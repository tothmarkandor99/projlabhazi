package projlabhazi;

import java.util.ArrayList;

public class Game implements Steppable {
	private int score;
	private int remainingPandas;
	private Entrance entrance;
	private Orangutan orangutan;
	private ArrayList<Tile> tiles;
	private Timer timer;
	
	private int inputDir = 0; //Teszteléshez TODO: kivenni
	
	public void printTiles() { //Teszteléshez TODO: kivenni
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
	
	public void Initialize(ArrayList<Tile> tiles, Tile entranceTile) {
		this.tiles = tiles;
		this.entrance = new Entrance();
		entrance.setTile(entranceTile);
		orangutan = new Orangutan(this);
		entrance.getTile().setObject(orangutan);
		orangutan.setTile(entrance.getTile());
		timer.addSteppable(orangutan);
		score = 0;
		remainingPandas = 0;
		for (Tile tile : tiles) {
			if (tile.getObject() instanceof Panda) {
				remainingPandas++;
			}
		}
	}
	
	public void addScore() {
		score += 20;
	}
	
	public void pandaDies() {
		remainingPandas--;
	}
	
	public void toStart() {
		Tile entr = entrance.getTile();
		for (int i = 0; i < entr.getSides(); i++) {
			if (entr.getNeighbour(i).receive(orangutan) == true) {
				orangutan.moveTo(entr);
				break;
			}
		}
	}
	
	public void newGame() {
		//TODO: pálya felépítése
		entrance.getTile().setObject(orangutan);
		inputDir = 0;
		//TODO: Timer start
	}
	
	public void endGame() {
		//TODO: Timer stop
	}
	
	@Override
	public void step() {
		if (remainingPandas == 0) {
			endGame();
		}
	}
	
}
