package projlabhazi;

public class Orangutan extends Character {
	public Orangutan(Game g) {
		super(g);
		ComInt.sendMessage("Orangutan.Orangutan");ComInt.indent++;
	}
	
	public void add(Panda p) {
		ComInt.sendMessage("Orangutan.add");ComInt.indent++;
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
	}
	
	public void countPanda() { //Megöli és megszámolja a begyûjtött pandákat
		ComInt.sendMessage("Orangutan.countPanda");ComInt.indent++;
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
	
	public void step() { //A felhasználói bemenet alapján próbálja mozgatni a pandát
		ComInt.sendMessage("Orangutan.step");ComInt.indent++;
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
		ComInt.sendMessage("Orangutan.release");ComInt.indent++;
		if (next != null) {
			next.release();
		}
		setNext(null);
	}
	
	public void die() {
		ComInt.sendMessage("Orangutan.die");ComInt.indent++;
		game.endGame();
	}
}
