package projlabhazi;

import java.util.ArrayList;

public class Game implements Steppable {
	private int score;
	private int remainingPandas;
	private Entrance entrance;
	private Orangutan orangutan;
	private ArrayList<Tile> tiles;
	private Timer timer;
	
	private int lastInput = 0; //Tesztel�shez TODO: kivenni
	
	public Timer getTimer () { //Tesztel�shez TODO: kivenni
		return timer;
	}
	
	public int getLastInput() { //Tesztel�shez TODO: kivenni
		return lastInput;
	}
	
	public void simulateInput(int i) { //Tesztel�shez TODO: kivenni �s �talak�tani wrapper oszt�lly�
		lastInput = i;
	}
	
	Game(ArrayList<Tile> tiles, Entrance entrance) { //Ez nincs benn a dokument�ci�ban
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
		//TODO: p�lya fel�p�t�se
		orangutan = new Orangutan();
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
