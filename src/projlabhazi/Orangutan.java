package projlabhazi;

public class Orangutan extends Character {
	public Orangutan(Game g) {
		super(g);
	}
	
	public void add(Panda p) {
		// Orangutan és panda megcserélése
		// Elõször a karakterek mezõ referenciáit cseréljük meg
		Tile tempTile = this.getTile();
		this.setTile(p.getTile());
		p.setTile(tempTile);
		
		// Aztán a mezõk karakter referenciáit
		this.getTile().setObject(this);
		p.getTile().setObject(p);
		
		// Új panda beillesztése a pandaláncba
		p.setNext(this.next);
		if (this.getNext() != null)
			this.getNext().setPrev(p);
		this.setNext(p);
		
		p.prev = this;
	}
	
	public void countPanda() {
		Panda temp = next;
		int pcs = 0;
		while (temp != null) {
			pcs++;
			Panda tempNext = temp.getNext();
			temp.kill();
			temp = tempNext;
		}
		game.addScore(pcs * 20);
		game.toStart();
	}
	
	public void step() {
		if (tile.getSides() != 0) {
			while (game.getInputDir() < 0) {
				game.addInputDir(tile.getSides());
			}
			if (tile.put(this, game.getInputDir() % tile.getSides())) { //TODO: user input
				this.moveTo(tile.getNeighbour(game.getInputDir() % tile.getSides())); //TODO: user input
			}
		}
	}
	
	public void release() {
		if (next != null) {
			next.release();
		}
		setNext(null);
	}
	
	public void die() {
		System.out.println("Meghaltam");
		game.endGame();
	}
}
