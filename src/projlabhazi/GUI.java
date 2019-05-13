package projlabhazi;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

/**
 * @author Mark
 * Megjeleníthetõ felhasználói felület
 */
public class GUI extends JPanel implements Steppable {
	/**
	 * Referencia a játékra, amit megjelenít
	 */
	private Game game;
	/**
	 * Csempék kirajzolható view-i
	 */
	private ArrayList<DrawableTile> drawableTiles;
	/**
	 * Csempék közötti szomszédságok kirajzolható view-i
	 */
	private ArrayList<DrawableConnection> drawableConnections;
	/**
	 * Ablak kezdõ szélessége, az elsõ renderelésig kell
	 */
	private int initialWidth;
	/**
	 * Billentyûleütések eseményének elkapásához kell
	 */
	static JLabel obj1 = new JLabel();
	/**
	 * Billentyûleütések eseményének elkapásához kell
	 */
	private static final int IFW = JComponent.WHEN_IN_FOCUSED_WINDOW;
	
	public GUI(int initialWidth) {
		super();
		this.initialWidth = initialWidth;
		drawableTiles = new ArrayList<DrawableTile>();
		drawableConnections = new ArrayList<DrawableConnection>();
	}
	
	/**
	 * @param g
	 * Inicializálja a view-kat és regisztrálja a billentyûleütés eseménykezelõket
	 */
	public void setGame(Game g) {
		game = g;
		generateDrawableTiles(initialWidth);
		generateDrawableConnections();
		
		obj1.getInputMap(IFW).put(KeyStroke.getKeyStroke("LEFT"), "LEFT");
		obj1.getInputMap(IFW).put(KeyStroke.getKeyStroke("RIGHT"), "RIGHT");
		obj1.getInputMap(IFW).put(KeyStroke.getKeyStroke("SPACE"), "SPACE");
		obj1.getInputMap(IFW).put(KeyStroke.getKeyStroke("R"), "R");
		
		obj1.getActionMap().put("LEFT", new TurnAction(true));
		obj1.getActionMap().put("RIGHT", new TurnAction(false));
		obj1.getActionMap().put("SPACE", new StepAction());
		obj1.getActionMap().put("R", new ReleaseAction());
		
		add(obj1);
	}
	
	/**
	 * @author Mark
	 * Akció osztály a nyilak megnyomásának eseményhez rendeléséhez
	 */
	private class TurnAction extends AbstractAction{
		private boolean left;
		TurnAction(boolean left) {
			this.left = left;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			game.simulateTurn(left);
			repaint();
		}
	}
	
	/**
	 * @author Mark
	 * Akció osztály a szóköz megnyomásának eseményhez rendeléséhez
	 */
	private class StepAction extends AbstractAction{
		@Override
		public void actionPerformed(ActionEvent e) {
			game.getOrangutan().step();
			repaint();
		}
	}
	
	/**
	 * @author Mark
	 * Akció osztály az 'R' megnyomásának eseményhez rendeléséhez
	 */
	private class ReleaseAction extends AbstractAction{
		@Override
		public void actionPerformed(ActionEvent e) {
			game.getOrangutan().release();
			repaint();
		}
	}
	
	
	
	/**
	 * @param WIDTH
	 * A játékban tárolt modellbõl megjeleníthetõ view-t állít elõ
	 * Elõször minden csempéhez készít egy view-t, aztán minden csempé álló objektumhoz is
	 * A view-k id-je a csempe modellek id-je lesz, így ez is egyedi
	 * A view-kat automatán helyezi el az ablakban
	 * Az objektumok view-inak egyedi id-t ad
	 */
	private void generateDrawableTiles(int WIDTH) {
		drawableTiles.clear();
		for (Tile tile : game.getTiles()) {
			int x, y;
			if (drawableTiles.isEmpty()) {
				x = DrawableTile.radius;
				y = DrawableTile.radius;
			} else {
				x = drawableTiles.get(drawableTiles.size() - 1).getX() + DrawableTile.radius * 4;
				if (x + DrawableTile.radius > WIDTH) {
					x = DrawableTile.radius;
					y = drawableTiles.get(drawableTiles.size() - 1).getY() + DrawableTile.radius * 4;
				} else {
					y = drawableTiles.get(drawableTiles.size() - 1).getY();
				}
			}
			DrawableTile drawableTile;
			if (tile instanceof BreakingTile) {
				drawableTile = new DrawableBreakingTile(tile.id, x, y);
			} else {
				if (game.getEntranceTiles().contains(tile)) {
					drawableTile = new DrawableEntranceTile(tile.id, x, y);
				} else {
					drawableTile = new DrawableTile(tile.id, x, y);
				}
			}
			drawableTiles.add(drawableTile);
		}
		for (Tile tile : game.getTiles()) {
			int j = 0;
			while (j < drawableTiles.size() && drawableTiles.get(j).getId() != tile.id) {
				j++;
			}
			DrawableTile drawableTile = drawableTiles.get(j);
			DrawableObject drawableObject = null;
			if (tile.getObject() instanceof Orangutan) {
				int i = 0;
				while (game.getInputDir() < 0)
					game.addInputDir(tile.getSides());
				while (i < drawableTiles.size() && drawableTiles.get(i).getId() != tile.getNeighbour(game.getInputDir() % tile.getSides()).id) {
					i++;
				}
				if (i != drawableTiles.size()) {
					drawableObject = new DrawableOrangutan(--DrawableObject.idCounter, drawableTiles.get(i), tile.id == game.getOrangutan().getTile().id);
				}
			} else if (tile.getObject() instanceof Exit) {
				drawableObject = new DrawableExit(--DrawableObject.idCounter);
			} else if (tile.getObject() instanceof GamePanda) {
				drawableObject = new DrawableGamePanda(--DrawableObject.idCounter);
			} else if (tile.getObject() instanceof SleepPanda) {
				drawableObject = new DrawableSleepPanda(--DrawableObject.idCounter);
			} else if (tile.getObject() instanceof ChocolatePanda) {
				drawableObject = new DrawableChocolatePanda(--DrawableObject.idCounter);
			} else if (tile.getObject() instanceof GameMachine) {
				drawableObject = new DrawableGameMachine(--DrawableObject.idCounter);
			} else if (tile.getObject() instanceof ChocolateMachine) {
				drawableObject = new DrawableChocolateMachine(--DrawableObject.idCounter);
			} else if (tile.getObject() instanceof ArmChair) {
				DrawableArmChair drawableArmChair = new DrawableArmChair(--DrawableObject.idCounter);
				if (((ArmChair)tile.getObject()).getSleepTime() == 0)
					drawableArmChair.setPanda(null);
				else 
					drawableArmChair.setPanda(new DrawableSleepPanda(--DrawableObject.idCounter));
				drawableObject = drawableArmChair;
			} else if (tile.getObject() instanceof Wardrobe) {
				drawableObject = new DrawableWardrobe(--DrawableObject.idCounter);
			}
			drawableTile.setObject(drawableObject);
		}
	}
	
	/**
	 * A szomszédos csempék közötti kapcsolatokat jelzõ view-kat generálja
	 */
	private void generateDrawableConnections() {
		drawableConnections.clear();
		for (DrawableTile drawableTile : drawableTiles) {
			int k = 0;
			while (k < game.getTiles().size() && drawableTile.getId() != game.getTiles().get(k).id) {
				k++;
			}
			if (k != game.getTiles().size()) {
				Tile tile = game.getTiles().get(k);
				for (int i = 0; i < tile.getSides(); i++) {
					Tile neighbour = tile.getNeighbour(i);
					int j = 0;
					while (j < drawableTiles.size() && drawableTiles.get(j).getId() != neighbour.id) {
						j++;
					}
					if (j != drawableTiles.size()) {
						drawableConnections.add(new DrawableConnection(drawableTile, drawableTiles.get(j)));
					}
				}
			}
		}
	}
	
	/**
	 * Kirajzolja a view-kat és kiírja a pontszámot
	 */
	@Override
	public void paintComponent(Graphics g) {
		int WIDTH = this.getWidth();
		int HEIGHT = this.getHeight();
		super.paintComponent(g);
		this.setBackground(Color.WHITE);
		
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		g2.setColor(Color.BLUE);
		g2.fillRect(WIDTH - 150 - 20, HEIGHT - 20 - 20, 150, 30);
		g2.setColor(Color.WHITE);
		String score = ((Integer)game.getScore()).toString();
		g2.drawString(score, WIDTH - 150 - 20 + 75, HEIGHT - 20);
		
		generateDrawableTiles(WIDTH);
		generateDrawableConnections();

		drawableConnections.forEach((DrawableConnection drawableConnection) -> {drawableConnection.Draw(g2);}) ;
		drawableTiles.forEach((DrawableTile drawableTile) -> {drawableTile.Draw(g2);}) ;
	}

	@Override
	public void step() {
		repaint();	
	}
	
}
