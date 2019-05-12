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
import java.util.HashMap;
import javax.swing.JPanel;

public class GUI extends JPanel {
	private Game game;
	private ArrayList<DrawableConnection> drawableConnections;
	private ArrayList<DrawableTile> drawableTiles;
	
	public void setGame(Game g) {
		game = g;
		drawableTiles.clear();
		for (Tile tile : game.getTiles()) {
			drawableTiles.add(new DrawableTile(tile));
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
	}
	
	public void addDrawableTile(DrawableTile drawableTile) {
		drawableTiles.add(drawableTile);
		// TODO: kapcsolatok feltérképezése
	}
	
	public void removeDrawableTile(DrawableTile drawableTile) {
		// TODO: megszûnõ kapcsolatok törlése
		drawableTiles.add(drawableTile);
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
			for (DrawableTile tile : drawableTiles) {
				for (int i = 0; i < tile.getSides(); i++) {
					Tile neighbour = tile.getNeighbour(i);
					int j = 0;
					while (j < drawableTiles.size() && drawableTiles.get(j).id != neighbour.id) {
						j++;
					}
					if (j != drawableTiles.size()) {
						drawableConnections.add(new DrawableConnection(tile, drawableTiles.get(j)));
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
