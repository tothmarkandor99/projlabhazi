package projlabhazi;

public class Orangutan extends Character {
	public Orangutan(Game g) {
		super(g);
	}
	
	public void add(Panda p) {
		//TODO: itt kell a swap-et megvalósítani
		// Orangutan és panda megcserélése
		// Elõször a karakterek mezõ referenciáit cseréljük meg
		Tile tempTile = this.getTile();
		this.setTile(p.getTile());
		p.setTile(tempTile);
		// Aztán a mezõk karakter referenciáit
		this.getTile().setObject(this);
		p.getTile().setObject(p);
		// Új panda beillesztése a pandaláncba
		p.next = this.next;
		this.next = p;
	}
	
	public void countPanda() {
		Character temp = next;
		int pcs = 0;
		while (temp != null) {
			pcs++;
			Character tempNext = temp.getNext();
			temp.die();
			temp = tempNext;
		}
		game.addScore();
		game.toStart();
	}
	
	public void step() {
		if (game.getInputSpace() == false) //Teszteléshez TODO: kivenni
			return; //Teszteléshez TODO: kivenni
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
		next = null;
	}
}
