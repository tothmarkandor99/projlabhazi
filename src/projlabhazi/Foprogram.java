package projlabhazi;

import java.util.ArrayList;

import javax.swing.JFrame;

public class Foprogram {
	
	/**
	 * @param args
	 * A jport�n megadott topol�gi�t implement�lja
	 * Kipr�b�l�shoz c�lszer� az ablakot �sszenyomni �gy, hogy 7x6 vagy 6x7 soros/oszopos legyen, �gy kicsit szebb
	 */
	public static void main(String[] args) {
		JFrame F = new JFrame();
		F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GUI G = new GUI(800);
		Timer timer = new Timer();
		timer.setGUI(G);
		ArrayList<Tile> tiles = new ArrayList<Tile>();
		ArrayList<Tile> entranceTiles = new ArrayList<Tile>();

		int i = 0;
		for (; i < 40; i++) {
			Tile tile = new Tile();
			tile.id = i;
			tiles.add(tile);
		}
		for (; i < 42; i++) {
			Tile tile = new BreakingTile();
			tile.id = i;
			tiles.add(tile);
		}
		tiles.get(0).addNeighbour(tiles.get(18));
		tiles.get(0).addNeighbour(tiles.get(40));
		tiles.get(1).addNeighbour(tiles.get(2));
		tiles.get(1).addNeighbour(tiles.get(16));
		tiles.get(2).addNeighbour(tiles.get(15));
		tiles.get(2).addNeighbour(tiles.get(16));
		tiles.get(3).addNeighbour(tiles.get(4));
		tiles.get(3).addNeighbour(tiles.get(14));
		tiles.get(3).addNeighbour(tiles.get(15));
		tiles.get(4).addNeighbour(tiles.get(5));
		tiles.get(4).addNeighbour(tiles.get(14));
		tiles.get(5).addNeighbour(tiles.get(6));
		tiles.get(5).addNeighbour(tiles.get(13));
		tiles.get(5).addNeighbour(tiles.get(14));
		tiles.get(6).addNeighbour(tiles.get(7));
		tiles.get(6).addNeighbour(tiles.get(13));
		tiles.get(7).addNeighbour(tiles.get(8));
		tiles.get(7).addNeighbour(tiles.get(11));
		tiles.get(7).addNeighbour(tiles.get(12));
		tiles.get(7).addNeighbour(tiles.get(13));
		tiles.get(8).addNeighbour(tiles.get(9));
		tiles.get(8).addNeighbour(tiles.get(11));
		tiles.get(9).addNeighbour(tiles.get(10));
		tiles.get(10).addNeighbour(tiles.get(27));
		tiles.get(11).addNeighbour(tiles.get(12));
		tiles.get(11).addNeighbour(tiles.get(27));
		tiles.get(12).addNeighbour(tiles.get(13));
		tiles.get(12).addNeighbour(tiles.get(26));
		tiles.get(12).addNeighbour(tiles.get(27));
		tiles.get(13).addNeighbour(tiles.get(14));
		tiles.get(13).addNeighbour(tiles.get(23));
		tiles.get(13).addNeighbour(tiles.get(24));
		tiles.get(13).addNeighbour(tiles.get(25));
		tiles.get(13).addNeighbour(tiles.get(26));
		tiles.get(14).addNeighbour(tiles.get(15));
		tiles.get(14).addNeighbour(tiles.get(20));
		tiles.get(14).addNeighbour(tiles.get(21));
		tiles.get(14).addNeighbour(tiles.get(22));
		tiles.get(14).addNeighbour(tiles.get(23));
		tiles.get(15).addNeighbour(tiles.get(16));
		tiles.get(15).addNeighbour(tiles.get(20));
		tiles.get(16).addNeighbour(tiles.get(17));
		tiles.get(16).addNeighbour(tiles.get(18));
		tiles.get(16).addNeighbour(tiles.get(19));
		tiles.get(16).addNeighbour(tiles.get(20));
		tiles.get(17).addNeighbour(tiles.get(18));
		tiles.get(18).addNeighbour(tiles.get(19));
		tiles.get(19).addNeighbour(tiles.get(20));
		tiles.get(19).addNeighbour(tiles.get(21));
		tiles.get(19).addNeighbour(tiles.get(40));
		tiles.get(20).addNeighbour(tiles.get(21));
		tiles.get(21).addNeighbour(tiles.get(22));
		tiles.get(21).addNeighbour(tiles.get(40));
		tiles.get(22).addNeighbour(tiles.get(23));
		tiles.get(22).addNeighbour(tiles.get(36));
		tiles.get(22).addNeighbour(tiles.get(37));
		tiles.get(23).addNeighbour(tiles.get(24));
		tiles.get(23).addNeighbour(tiles.get(36));
		tiles.get(24).addNeighbour(tiles.get(25));
		tiles.get(24).addNeighbour(tiles.get(34));
		tiles.get(24).addNeighbour(tiles.get(36));
		tiles.get(25).addNeighbour(tiles.get(26));
		tiles.get(25).addNeighbour(tiles.get(41));
		tiles.get(26).addNeighbour(tiles.get(27));
		tiles.get(26).addNeighbour(tiles.get(30));
		tiles.get(27).addNeighbour(tiles.get(28));
		tiles.get(27).addNeighbour(tiles.get(29));
		tiles.get(27).addNeighbour(tiles.get(30));
		tiles.get(28).addNeighbour(tiles.get(29));
		tiles.get(29).addNeighbour(tiles.get(30));
		tiles.get(29).addNeighbour(tiles.get(31));
		tiles.get(30).addNeighbour(tiles.get(31));
		tiles.get(30).addNeighbour(tiles.get(41));
		tiles.get(31).addNeighbour(tiles.get(32));
		tiles.get(31).addNeighbour(tiles.get(33));
		tiles.get(31).addNeighbour(tiles.get(41));
		tiles.get(32).addNeighbour(tiles.get(33));
		tiles.get(33).addNeighbour(tiles.get(35));
		tiles.get(33).addNeighbour(tiles.get(41));
		tiles.get(34).addNeighbour(tiles.get(35));
		tiles.get(34).addNeighbour(tiles.get(36));
		tiles.get(34).addNeighbour(tiles.get(41));
		tiles.get(35).addNeighbour(tiles.get(36));
		tiles.get(36).addNeighbour(tiles.get(37));
		tiles.get(36).addNeighbour(tiles.get(38));
		tiles.get(37).addNeighbour(tiles.get(38));
		tiles.get(37).addNeighbour(tiles.get(40));
		tiles.get(38).addNeighbour(tiles.get(39));
		tiles.get(39).addNeighbour(tiles.get(40));
		
		entranceTiles.add(tiles.get(16));
		
		Game g = new Game(timer);
		tiles.get(3).setObject(new GamePanda(g, tiles.get(3)));
		tiles.get(5).setObject(new ChocolatePanda(g, tiles.get(5)));
		tiles.get(10).setObject(new SleepPanda(g, tiles.get(10)));
		tiles.get(11).setObject(new ChocolatePanda(g, tiles.get(11)));
		tiles.get(22).setObject(new GamePanda(g, tiles.get(22)));
		tiles.get(33).setObject(new SleepPanda(g, tiles.get(33)));
		int countPandas = 6;
		
		tiles.get(13).setObject(new GameMachine(tiles.get(13)));
		tiles.get(27).setObject(new Exit());
		tiles.get(28).setObject(new Wardrobe(tiles.get(28)));
		tiles.get(32).setObject(new ArmChair(tiles.get(32)));
		tiles.get(36).setObject(new ChocolateMachine(tiles.get(36)));
		tiles.get(39).setObject(new Wardrobe(tiles.get(39)));
		

		//be�ll�tani hogy a j�t�kban a csemp�knek a poz�ci�ja adott, nem aut�matikusan kell kisz�molni
		G.setFixedPos(true);
		
		
		G.addTileFixedPos(0, 150, 190);
		G.addTileFixedPos(1, 80, 30);
		G.addTileFixedPos(2, 140, 30);
		G.addTileFixedPos(3, 250, 30);
		G.addTileFixedPos(4, 320, 30);
		G.addTileFixedPos(5, 400, 30);
		G.addTileFixedPos(6, 460, 30);
		G.addTileFixedPos(7, 520, 40);
		G.addTileFixedPos(8, 600, 30);
		G.addTileFixedPos(9, 650, 25);
		G.addTileFixedPos(10, 710, 55);
		G.addTileFixedPos(11, 650, 75);
		G.addTileFixedPos(12, 570, 80);
		G.addTileFixedPos(13, 500, 110);
		G.addTileFixedPos(14, 360, 110);
		G.addTileFixedPos(15, 230, 70);
		G.addTileFixedPos(16, 120, 100);
		G.addTileFixedPos(17, 50, 150);
		G.addTileFixedPos(18, 110, 150);
		G.addTileFixedPos(19, 170, 150);
		G.addTileFixedPos(20, 220, 120);
		G.addTileFixedPos(21, 300, 150);
		G.addTileFixedPos(22, 360, 155);
		G.addTileFixedPos(23, 410, 155);
		G.addTileFixedPos(24, 490, 160);
		G.addTileFixedPos(25, 570, 150);
		G.addTileFixedPos(26, 600, 120);
		G.addTileFixedPos(27, 700, 110);
		G.addTileFixedPos(28, 760, 160);
		G.addTileFixedPos(29, 710, 160);
		G.addTileFixedPos(30, 660, 150);
		G.addTileFixedPos(31, 650, 210);
		G.addTileFixedPos(32, 650, 260);
		G.addTileFixedPos(33, 600, 230);
		G.addTileFixedPos(34, 530, 200);
		G.addTileFixedPos(35, 530, 250);
		G.addTileFixedPos(36, 420, 210);
		G.addTileFixedPos(37, 330, 205);
		G.addTileFixedPos(38, 330, 260);
		G.addTileFixedPos(39, 240, 230);
		G.addTileFixedPos(40, 240, 180);
		G.addTileFixedPos(41, 600, 180);
		
		g.newGame(tiles, entranceTiles, countPandas);

		G.setGame(g);
		F.add(G);
		F.setSize(800, 600);
		F.setVisible(true);
	}
}
