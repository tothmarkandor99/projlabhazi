package projlabhazi;

import java.util.ArrayList;

public class Game implements Steppable {
	private int score;
	private int remainingPandas;
	private Tile entranceTile; // Eltér a dokumentációtól
	private Orangutan orangutan;
	private ArrayList<Tile> tiles;
	private Timer timer;
	
	private int inputDir = 0; //Teszteléshez TODO: kivenni
	
	public void printTiles() { //Teszteléshez TODO: kivenni
		System.out.println("EntranceTile: " + entranceTile.id);
		if (orangutan.getTile().getSides() == 0) {
			System.out.println("Az orángutánnak nincs szomszédos mezõ");
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
	
	public Timer getTimer () { //Teszteléshez TODO: kivenni
		return timer;
	}
	
	public int getInputDir() { //Teszteléshez TODO: kivenni
		return inputDir;
	}
	
	public void addInputDir(int i) { //Teszteléshez TODO: kivenni
		inputDir += i;
	}
	
	public int getScore() { //Tesztelésheza TODO: kivenni
		return score;
	}
	
	public void simulateTurn(boolean left) { //Teszteléshez TODO: kivenni
		inputDir += left ? 1 : -1; 
	}

	public Orangutan getOrangutan( ) { //Tesztelésheza TODO: kivenni
		return orangutan;
	}
	
	Game(Timer t) { //Ez nincs benn a dokumentációban
		timer = t;
	}
	
	public void newGame(ArrayList<Tile> tiles, Tile entranceTile, int countPandas) { //Eltér a dokumentációtól
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
