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
	
	public void printTiles() { //Teszteléshez TODO: kivenni
		ComInt.println("Orangutans: " + entranceTiles.size());

		for (int i = 0; i < tiles.size(); i++) {
			ComInt.print(i + "\t");
			tiles.get(i).print();
			ComInt.print("\t Neighbours:");
			for(int j=0; j<tiles.get(i).getSides(); j++) 
				ComInt.print(" " + j +": "+tiles.get(i).getNeighbour(j).getClass());
			ComInt.println();
		}
	}
	
	public Timer getTimer () { //Teszteléshez TODO: kivenni
		ComInt.println("Game.getTimer");ComInt.indent++;
		return timer;
	}
	
	public int getInputDir() { //Teszteléshez TODO: kivenni
		ComInt.println("Game.getInputDir");ComInt.indent++;
		return inputDir;
	}
	
	public void addInputDir(int i) { //Teszteléshez TODO: kivenni
		ComInt.println("Game.addInputDir");ComInt.indent++;
		inputDir += i;
	}
	
	public int getScore() { //Teszteléshez TODO: kivenni
		ComInt.println("Game.getScore");ComInt.indent++;
		return score;
	}
	
	public void simulateTurn(boolean left) { //Teszteléshez TODO: kivenni
		ComInt.println("Game.simulateTurn");ComInt.indent++;
		inputDir += left ? 1 : -1; 
	}

	public void activateOrangutan(int i) {
		ComInt.println("Game.activateOrangutan");ComInt.indent++;
		if (i < 0 || i >= orangutans.size())
			return;
		activeOrangutan = orangutans.get(i);
	}
	
	public Orangutan getOrangutan( ) { //Teszteléshez TODO: kivenni
		ComInt.println("Game.getOrangutan");ComInt.indent++;
		return activeOrangutan;
	}
	
	Game(Timer t) { //Ez nincs benn a dokumentációban
		ComInt.println("Game.Game");ComInt.indent++;
		timer = t;
	}
	
	public void newGame(ArrayList<Tile> tiles, ArrayList<Tile> entranceTiles, int countPandas) { //Eltér a dokumentációtól, teszteléshez átalakítva
		ComInt.println("Game.newGame");ComInt.indent++;
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
			timer.addSteppable(activeOrangutan);
		}
		timer.start();
	}
	
	public void addScore(int s) {
		ComInt.println("Game.addScore");ComInt.indent++;
		score += s;
	}
	
	public void pandaDies() {
		ComInt.println("Game.pandaDies");ComInt.indent++;
		remainingPandas--;
	}
	
	public void toStart() {
		ComInt.println("Game.toStart");ComInt.indent++;
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
		ComInt.println("Game.endGame");ComInt.indent++;
		timer.stop();
	}
	
	@Override
	public void step() {
		ComInt.println("Game.step");ComInt.indent++;
		if (remainingPandas == 0) {
			endGame();
		}
	}
	
}
