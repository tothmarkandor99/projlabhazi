package projlabhazi;

import java.util.ArrayList;

import javax.swing.JFrame;

public class ComInt {
	
	public static void main(String[] args) {
		JFrame F = new JFrame();
		F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GUI G = new GUI();
		Timer timer = new Timer();
		
		ArrayList<Tile> tiles = new ArrayList<Tile>();
		ArrayList<Tile> entranceTiles = new ArrayList<Tile>();

		Tile tile = null;
		Tile lastTile = null;
		for (int i = 0; i < 6; i++) {
			lastTile = tile;
			tile = new Tile();
			tile.id = i;
			tiles.add(tile);
			
			if (i > 0) {
				tile.addNeighbour(lastTile);
			}
			
			if (i == 3 || i == 5) {
				entranceTiles.add(tile);
			}
			
			if (i == 1) {
				tile.setObject(new Exit());
			}
		}
		int countPandas = 0;
		
		
		Game g = new Game(timer);
		g.newGame(tiles, entranceTiles, countPandas);
		G.setGame(g);
		F.add(G);
		F.setSize(800, 600);
		F.setVisible(true);
	}	
}
