package projlabhazi;

public class Orangutan extends Character {
	public Orangutan(Game g) {
		super(g);
	}
	
	public void add(Panda p) {
		
		if (p.prev == null) {
			// Orangutan és felvett panda megcserélése
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
		} else {
			Panda endPanda = p;
			while (endPanda.next != null) {
				endPanda = endPanda.next;
			}
			endPanda.next = this.next;
			this.next.setPrev(endPanda);
			p.setPrev(this);
			this.setNext(p);
			p.moveTo(p.tile);
		}
	}
	
	public void countPanda() { //Megöli és megszámolja a begyûjtött pandákat
		
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
	
	public void step() { //A felhasználói bemenet alapján próbálja mozgatni az orángutánt
		if (tile.getSides() != 0) {
			while (game.getInputDir() < 0) {
				game.addInputDir(tile.getSides());
			}
			if (tile.put(this, game.getInputDir() % tile.getSides())) { //TODO: user input
				this.moveTo(tile.getNeighbour(game.getInputDir() % tile.getSides())); //TODO: user input
			}
		}
	}
	
	public void release() { //Elengedi az utána álló pandát
		
		if (next != null) {
			next.release();
		}
		setNext(null);
	}
	
	public void die() {
		
		game.endGame();
	}
}
