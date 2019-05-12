package projlabhazi;

import java.util.ArrayList;

public class Game implements Steppable {
	private int score;
	private int remainingPandas;
	private ArrayList<Entrance> entranceTiles; // Elt�r a dokument�ci�t�l
	private ArrayList<Orangutan> orangutans;
	private Orangutan activeOrangutan;
	private ArrayList<Tile> tiles;
	private Timer timer;
	
	private int inputDir = 0; //Tesztel�shez TODO: kivenni
	
	public Timer getTimer () { //Tesztel�shez TODO: kivenni
		
		return timer;
	}
	
	public int getInputDir() { //Tesztel�shez TODO: kivenni
		
		return inputDir;
	}
	
	public void addInputDir(int i) { //Tesztel�shez TODO: kivenni
		
		inputDir += i;
	}
	
	public int getScore() { //Tesztel�shez TODO: kivenni
		
		return score;
	}
	
	public void simulateTurn(boolean left) { //Tesztel�shez TODO: kivenni
		
		inputDir += left ? 1 : -1; 
	}

	public void activateOrangutan(int i) {
		
		if (i < 0 || i >= orangutans.size())
			return;
		activeOrangutan = orangutans.get(i);
	}
	
	public Orangutan getOrangutan( ) { //Tesztel�shez TODO: kivenni
		
		return activeOrangutan;
	}
	
	Game(Timer t) { //Ez nincs benn a dokument�ci�ban
		
		timer = t;
	}
	
	public void newGame(ArrayList<Tile> tiles, ArrayList<Entrance> entranceTiles, int countPandas) { //Elt�r a dokument�ci�t�l, tesztel�shez �talak�tva
		
		//K�ls� forr�sb�l inicializ�lja a j�t�kot
		orangutans = new ArrayList<Orangutan>();
		this.tiles = tiles;
		this.entranceTiles = entranceTiles;
		score = 0;
		remainingPandas = countPandas;
		for (Tile entranceTile : entranceTiles) {
			activeOrangutan = new Orangutan(this);
			activeOrangutan.setTile(entranceTile);
			entranceTile.setObject(activeOrangutan);
			orangutans.add(activeOrangutan);
			timer.addSteppable(activeOrangutan);
		}
		timer.start();
	}
	
	public void addScore(int s) {
		
		score += s;
	}
	
	public void pandaDies() {
		
		remainingPandas--;
	}
	
	public void toStart() {
		
		for (Orangutan orangutan : orangutans) {
			timer.removeSteppable(orangutan);
		}
		orangutans.clear();
		for (Tile entranceTile : entranceTiles) {
			activeOrangutan = new Orangutan(this);
			activeOrangutan.setTile(entranceTile);
			entranceTile.setObject(activeOrangutan);
			orangutans.add(activeOrangutan);
			timer.addSteppable(activeOrangutan);
		}
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
	
	public ArrayList<Tile> getTiles() {
		return tiles;
	}
	
}
