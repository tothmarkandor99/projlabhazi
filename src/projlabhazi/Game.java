package projlabhazi;

import java.util.ArrayList;

public class Game implements Steppable {
	private int score;
	private int remainingPandas;
	private Entrance entrance;
	private Orangutan orangutan;
	private ArrayList<Tile> tiles;
	private Timer timer;
	
	public Timer getTimer () {
		return timer;
	}
	
	Game(ArrayList<Tile> tiles, Entrance entrance) { //Ez nincs benn a dokumentációban
		this.tiles = tiles;
		this.entrance = entrance;
		timer = new Timer();
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
		orangutan = new Orangutan();
		
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
