package projlabhazi;

import java.util.ArrayList;

public class Game implements Steppable {
	private int score;
	private int remainingPandas;
	private Tile entranceTile; // Eltér a dokumentációtól
	private Orangutan orangutan;
	private ArrayList<Tile> tiles;
	private Timer timer;
	
	private int inputDir = 0; //Teszteléshez TODO: kivenni
	
	public void printTiles() { //Teszteléshez TODO: kivenni
		ComInt.sendMessage("EntranceTile: " + entranceTile.id);
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
		ComInt.sendMessage("Game.getTimer");ComInt.indent++;
		return timer;
	}
	
	public int getInputDir() { //Teszteléshez TODO: kivenni
		ComInt.sendMessage("Game.getInputDir");ComInt.indent++;
		return inputDir;
	}
	
	public void addInputDir(int i) { //Teszteléshez TODO: kivenni
		ComInt.sendMessage("Game.addInputDir");ComInt.indent++;
		inputDir += i;
	}
	
	public int getScore() { //Teszteléshez TODO: kivenni
		ComInt.sendMessage("Game.getScore");ComInt.indent++;
		return score;
	}
	
	public void simulateTurn(boolean left) { //Teszteléshez TODO: kivenni
		ComInt.sendMessage("Game.simulateTurn");ComInt.indent++;
		inputDir += left ? 1 : -1; 
	}

	public Orangutan getOrangutan( ) { //Tesztelésheza TODO: kivenni
		ComInt.sendMessage("Game.getOrangutan");ComInt.indent++;
		return orangutan;
	}
	
	Game(Timer t) { //Ez nincs benn a dokumentációban
		ComInt.sendMessage("Game.Game");ComInt.indent++;
		timer = t;
	}
	
	public void newGame(ArrayList<Tile> tiles, Tile entranceTile, int countPandas) { //Eltér a dokumentációtól, teszteléshez átalakítva
		ComInt.sendMessage("Game.newGame");ComInt.indent++;
		//Külsõ forrásból inicializálja a játékot
		this.tiles = tiles;
		this.entranceTile = entranceTile;
		timer.addSteppable(orangutan);
		score = 0;
		remainingPandas = countPandas;
		orangutan = new Orangutan(this);
		orangutan.setTile(entranceTile);
		entranceTile.setObject(orangutan);
		timer.start();
	}
	
	public void addScore(int s) {
		ComInt.sendMessage("Game.addScore");ComInt.indent++;
		score += s;
	}
	
	public void pandaDies() {
		ComInt.sendMessage("Game.pandaDies");ComInt.indent++;
		remainingPandas--;
	}
	
	public void toStart() {
		ComInt.sendMessage("Game.toStart");ComInt.indent++;
		orangutan.moveTo(entranceTile);
	}
	
	public void endGame() {
		ComInt.sendMessage("Game.endGame");ComInt.indent++;
		timer.stop();
	}
	
	@Override
	public void step() {
		ComInt.sendMessage("Game.step");ComInt.indent++;
		if (remainingPandas == 0) {
			endGame();
		}
	}
	
}
