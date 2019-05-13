package projlabhazi;

import java.util.ArrayList;

public class Game implements Steppable {
	private int score;
	private int remainingPandas;
	private ArrayList<Tile> entranceTiles; // Eltér a dokumentációtól
	private ArrayList<Orangutan> orangutans;
	private Orangutan activeOrangutan;
	private ArrayList<Tile> tiles;
	private Timer timer;
	
	private int inputDir = 0; //Teszteléshez TODO: kivenni
	
	public Timer getTimer () { //Teszteléshez TODO: kivenni
		
		return timer;
	}
	
	public int getInputDir() { //Teszteléshez TODO: kivenni
		
		return inputDir;
	}
	
	public void addInputDir(int i) { //Teszteléshez TODO: kivenni
		
		inputDir += i;
	}
	
	public int getScore() { //Teszteléshez TODO: kivenni
		
		return score;
	}
	
	public void simulateTurn(boolean left) { //Teszteléshez TODO: kivenni
		
		inputDir += left ? 1 : -1; 
	}

	public void activateOrangutan(int i) {
		
		if (i < 0 || i >= orangutans.size())
			return;
		activeOrangutan = orangutans.get(i);
	}
	
	public Orangutan getOrangutan( ) { //Teszteléshez TODO: kivenni
		
		return activeOrangutan;
	}
	
	Game(Timer t) { //Ez nincs benn a dokumentációban
		timer = t;
	}
	
	public void newGame(ArrayList<Tile> tiles, ArrayList<Tile> entranceTiles, int countPandas) { //Eltér a dokumentációtól, teszteléshez átalakítva
		timer.clearSteppables();
		
		for (Tile tile : tiles) {
			if (tile.getObject() != null)
				timer.addSteppable(tile.getObject());
		}
		
		//Külsõ forrásból inicializálja a játékot
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
		activeOrangutan.tile.setObject(null);
		orangutans.clear();
		for (Tile entranceTile : entranceTiles) {
			activeOrangutan = new Orangutan(this);
			activeOrangutan.setTile(entranceTile);
			entranceTile.setObject(activeOrangutan);
			orangutans.add(activeOrangutan);
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
	
	public ArrayList<Tile> getEntranceTiles() {
		return entranceTiles;
	}
	
}
