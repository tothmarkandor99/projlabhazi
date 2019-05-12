package projlabhazi;

import java.awt.Color;
import java.awt.Graphics;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JPanel;

public class GUI extends JPanel {
	private Game game;
	private ArrayList<DrawableTile> drawableTiles;
	private ArrayList<DrawableConnection> drawableConnections;
	
	public GUI() {
		super();
		drawableTiles = new ArrayList<DrawableTile>();
		drawableConnections = new ArrayList<DrawableConnection>();
	}
	
	public void setGame(Game g) {
		game = g;
		drawableTiles.clear();
		for (Tile tile : game.getTiles()) {
			int x, y;
			if (drawableTiles.isEmpty()) {
				x = DrawableTile.radius;
				y = DrawableTile.radius;
			} else {
				x = drawableTiles.get(drawableTiles.size() - 1).getX() + DrawableTile.radius * 4;
				if (x + DrawableTile.radius > this.getWidth()) {
					x = DrawableTile.radius;
					y = drawableTiles.get(drawableTiles.size() - 1).getY() + DrawableTile.radius * 4;
				} else {
					y = drawableTiles.get(drawableTiles.size() - 1).getY();
				}
			}
			DrawableTile drawableTile = new DrawableTile(tile.id, x, y);
			drawableTiles.add(drawableTile);
		}
		drawableConnections.clear();
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		int WIDTH = this.getWidth();
		int HEIGHT = this.getHeight();
		super.paintComponent(g);
		this.setBackground(Color.WHITE);
		
		g.setColor(Color.BLUE);
		g.fillRect(WIDTH - 150 - 20, HEIGHT - 20 - 20, 150, 30);
		g.setColor(Color.WHITE);
		String score = ((Integer)game.getScore()).toString();
		g.drawString(score, WIDTH - 150 - 20 + 75, HEIGHT - 20);
		
		drawableTiles.forEach((DrawableTile drawableTile) -> {drawableTile.Draw(g);}) ;
		drawableConnections.forEach((DrawableConnection drawableConnection) -> {drawableConnection.Draw(g);}) ;
	}
	
	public void saveToFile(String fileName) {
		try {
			FileOutputStream file = new FileOutputStream(fileName); 
			ObjectOutputStream out = new ObjectOutputStream(file);
			
			out.writeObject(drawableTiles);
		} catch (IOException e) {
			System.out.println("Save failed");
		}
	}

	public void loadFromFile(String fileName) {
		try {
			FileInputStream file = new FileInputStream(fileName);
			ObjectInputStream in = new ObjectInputStream(file);
			
			drawableTiles = (ArrayList<DrawableTile>)in.readObject();
			
			drawableConnections.clear();
			for (DrawableTile drawableTile : drawableTiles) {
				int k = 0;
				while (k < game.getTiles().size() || drawableTile.getId() != game.getTiles().get(k).id) {
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
		} catch (FileNotFoundException e) {
			System.out.println("Load failed");
		} catch (IOException e) {
			System.out.println("Load failed");
		} catch (ClassNotFoundException e) {
			System.out.println("Load failed");
		} 
	}
}
