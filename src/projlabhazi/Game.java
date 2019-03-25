package projlabhazi;

import java.util.ArrayList;

public class Game implements Steppable {
	private int score;
	private int remainingPandas;
	private Tile entranceTile; // Elt�r a dokument�ci�t�l
	private Orangutan orangutan;
	private ArrayList<Tile> tiles;
	private Timer timer;
	
	private int inputDir = 0; //Tesztel�shez TODO: kivenni
	
	public void printTiles() { //Tesztel�shez TODO: kivenni
		System.out.println("EntranceTile: " + entranceTile.id);
		if (orangutan.getTile().getSides() == 0) {
			System.out.println("Az or�ngut�nnak nincs szomsz�dos mez�");
		} else {
			System.out.println("Last input:" + inputDir % orangutan.getTile().getSides());
		}
		for (int i = 0; i < tiles.size(); i++) {
			System.out.print(i + "\t");
			tiles.get(i).print();
			System.out.print("\t Neighbours:");
			for(int j=0; j<tiles.get(i).getSides(); j++) 
				System.out.print(" " + j +": "+tiles.get(i).getNeighbour(j).getClass());
			System.out.println();
		}
	}
	
	public Timer getTimer () { //Tesztel�shez TODO: kivenni
		return timer;
	}
	
	public int getInputDir() { //Tesztel�shez TODO: kivenni
		return inputDir;
	}
	
	public void addInputDir(int i) { //Tesztel�shez TODO: kivenni
		inputDir += i;
	}
	
	public int getScore() { //Tesztel�sheza TODO: kivenni
		return score;
	}
	
	public void simulateTurn(boolean left) { //Tesztel�shez TODO: kivenni
		inputDir += left ? 1 : -1; 
	}

	public Orangutan getOrangutan( ) { //Tesztel�sheza TODO: kivenni
		return orangutan;
	}
	
	Game(Timer t) { //Ez nincs benn a dokument�ci�ban
		timer = t;
	}
	
	public void newGame(ArrayList<Tile> tiles, Tile entranceTile, int countPandas) { //Elt�r a dokument�ci�t�l
		this.tiles = tiles;
		this.entranceTile = entranceTile;
		timer.addSteppable(orangutan);
		score = 0;
		remainingPandas = countPandas;
		orangutan = new Orangutan(this);
		orangutan.setTile(entranceTile);
		entranceTile.setObject(orangutan);
		timer.start();
	}
	
	public void addScore(int s) {
		score += s;
	}
	
	public void pandaDies() {
		remainingPandas--;
	}
	
	public void toStart() {
		orangutan.moveTo(entranceTile);
	}
	
	public void endGame() {
		timer.stop();
	}
	
	@Override
	public void step() {
		if (remainingPandas == 0) {
			endGame();
		}
	}
	
}
