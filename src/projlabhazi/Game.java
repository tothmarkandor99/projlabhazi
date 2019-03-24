package projlabhazi;

import java.util.ArrayList;

public class Game implements Steppable {
	private int score;
	private int remainingPandas;
	private Entrance entrance;
	private Orangutan orangutan;
	private ArrayList<Tile> tiles;
	private Timer timer;
	
	private int lastInput = 0; //Teszteléshez TODO: kivenni
	
	public void printTiles() { //Teszteléshez TODO: kivenni
		System.out.println("Last input:" + lastInput);
		for (int i = 0; i < tiles.size(); i++) {
			System.out.print(i + "\t");
			tiles.get(i).print();
		}
	}
	
	public Timer getTimer () { //Teszteléshez TODO: kivenni
		return timer;
	}
	
	public int getLastInput() { //Teszteléshez TODO: kivenni
		return lastInput;
	}
	
	public int getScore() {
		return score;
	}
	
	public void simulateInput(int i) { //Teszteléshez TODO: kivenni és átalakítani wrapper osztállyá
		lastInput = i;
	}
	
	Game(Timer t) { //Ez nincs benn a dokumentációban
		timer = t;
	}
	
	public void Initialize(ArrayList<Tile> tiles, Tile entranceTile) {
		this.tiles = tiles;
		this.entrance = new Entrance();
		entrance.setTile(entranceTile);
		entranceTile.setObject(entrance);
		orangutan = new Orangutan(this);
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
		lastInput = -1;
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
