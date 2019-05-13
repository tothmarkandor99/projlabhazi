package projlabhazi;

import java.util.ArrayList;

/**
 * @author Mark
 * J�t�k oszt�ly
 * Tartalmaz minden a j�t�k szempontj�b�l l�nyeges elemet, kiv�ve a megjelen�t�shez sz�ks�geseket
 * Azok a GUI �s a Drawable kezdet� oszt�lyokban vannak
 */
public class Game implements Steppable {
	/**
	 * Pontsz�m
	 */
	private int score;
	/**
	 * �sszegy�jtend� pand�k sz�ma
	 */
	private int remainingPandas;
	/**
	 * Ezeken a csemp�ken jelenik meg or�ngut�n a j�t�k ind�t�sakor
	 */
	private ArrayList<Tile> entranceTiles;
	/**
	 * Or�ngut�nok
	 */
	private ArrayList<Orangutan> orangutans;
	/**
	 * �ppen ir�ny�tott or�ngut�n
	 */
	private Orangutan activeOrangutan;
	/**
	 * Csemp�k
	 */
	private ArrayList<Tile> tiles;
	/**
	 * Id�z�t�
	 */
	private Timer timer;
	
	/**
	 * Akt�v or�ngut�n merre l�pjen tov�bb
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

	Game(Timer t) {
		timer = t;
	}
	
	/**
	 * @param tiles
	 * @param entranceTiles
	 * @param countPandas
	 * K�ls� forr�sb�l inicializ�lja a j�t�kot
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
	 * Kezd��llapotba viszi a j�t�kot
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
