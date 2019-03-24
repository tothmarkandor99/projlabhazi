package projlabhazi;

import java.util.ArrayList;

public class Game implements Steppable {
	private int score;
	private int remainingPandas;
	private Entrance entrance;
	private Orangutan orangutan;
	private ArrayList<Tile> tiles;
	private Timer timer;
	
	private int inputDir = 0; //Tesztel�shez TODO: kivenni
	private boolean inputSpace = false; //Tesztel�shez TODO: kivenni
	
	public void printTiles() { //Tesztel�shez TODO: kivenni
		if (orangutan.getTile().getSides() == 0) {
			System.out.println("Az or�ngut�nnak nincs szomsz�dos mez�");
		} else {
			System.out.println("Last input:" + inputDir % orangutan.getTile().getSides());
		}
		for (int i = 0; i < tiles.size(); i++) {
			System.out.print(i + "\t");
			tiles.get(i).print();
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
	
	public boolean getInputSpace() { //Tesztel�shez TODO: kivenni
		return inputSpace;
	}
	
	public int getScore() { //Tesztel�sheza TODO: kivenni
		return score;
	}
	
	public void simulateTurn(boolean left) { //Tesztel�shez TODO: kivenni �s �talak�tani wrapper oszt�lly�
		inputDir += left ? 1 : -1; 
	}
	
	public void simulateInput(boolean space) { //Tesztel�shez TODO: kivenni �s �talak�tani wrapper oszt�lly�
		inputSpace = space;
	}
	
	Game(Timer t) { //Ez nincs benn a dokument�ci�ban
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
		//TODO: p�lya fel�p�t�se
		entrance.getTile().setObject(orangutan);
		inputDir = 0;
		inputSpace = false;
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
