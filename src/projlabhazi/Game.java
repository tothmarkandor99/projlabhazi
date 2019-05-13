package projlabhazi;

import java.util.ArrayList;

/**
 * @author Mark
 * Játék osztály
 * Tartalmaz minden a játék szempontjából lényeges elemet, kivéve a megjelenítéshez szükségeseket
 * Azok a GUI és a Drawable kezdetû osztályokban vannak
 */
public class Game implements Steppable {
	/**
	 * Pontszám
	 */
	private int score;
	/**
	 * Összegyûjtendõ pandák száma
	 */
	private int remainingPandas;
	/**
	 * Ezeken a csempéken jelenik meg orángután a játék indításakor
	 */
	private ArrayList<Tile> entranceTiles;
	/**
	 * Orángutánok
	 */
	private ArrayList<Orangutan> orangutans;
	/**
	 * Éppen irányított orángután
	 */
	private Orangutan activeOrangutan;
	/**
	 * Csempék
	 */
	private ArrayList<Tile> tiles;
	/**
	 * Idõzítõ
	 */
	private Timer timer;
	
	/**
	 * Aktív orángután merre lépjen tovább
	 */
	private int inputDir = 0;

	public Timer getTimer () {
		
		return timer;
	}

	public int getInputDir() {
		
		return inputDir;
	}

	public void addInputDir(int i) {
		
		inputDir += i;
	}

	public int getScore() {
		
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

	Game(Timer t) {
		timer = t;
	}
	
	/**
	 * @param tiles
	 * @param entranceTiles
	 * @param countPandas
	 * Külsõ forrásból inicializálja a játékot
	 */
	public void newGame(ArrayList<Tile> tiles, ArrayList<Tile> entranceTiles, int countPandas) {
		timer.clearSteppables();
		
		for (Tile tile : tiles) {
			if (tile.getObject() != null)
				timer.addSteppable(tile.getObject());
		}
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
	
	/**
	 * Kezdõállapotba viszi a játékot
	 */
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
