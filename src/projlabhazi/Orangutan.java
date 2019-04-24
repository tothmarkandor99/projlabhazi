package projlabhazi;

public class Orangutan extends Character {
	public Orangutan(Game g) {
		super(g);
		ComInt.print("Orangutan.Orangutan");ComInt.indent++;
	}
	
	public void add(Panda p) {
		ComInt.print("Orangutan.add");ComInt.indent++;
		if (p.prev == null) {
			// Orangutan �s felvett panda megcser�l�se
			// El�sz�r a karakterek mez� referenci�it cser�lj�k meg
			Tile tempTile = this.getTile();
			this.setTile(p.getTile());
			p.setTile(tempTile);
			
			// Azt�n a mez�k karakter referenci�it
			this.getTile().setObject(this);
			p.getTile().setObject(p);
			
			// �j panda beilleszt�se a pandal�ncba
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
	
	public void countPanda() { //Meg�li �s megsz�molja a begy�jt�tt pand�kat
		ComInt.print("Orangutan.countPanda");ComInt.indent++;
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
	
	public void step() { //A felhaszn�l�i bemenet alapj�n pr�b�lja mozgatni a pand�t
		ComInt.print("Orangutan.step");ComInt.indent++;
		if (tile.getSides() != 0) {
			while (game.getInputDir() < 0) {
				game.addInputDir(tile.getSides());
			}
			if (tile.put(this, game.getInputDir() % tile.getSides())) { //TODO: user input
				this.moveTo(tile.getNeighbour(game.getInputDir() % tile.getSides())); //TODO: user input
			}
		}
	}
	
	public void release() { //Elengedi az ut�na �ll� pand�t
		ComInt.print("Orangutan.release");ComInt.indent++;
		if (next != null) {
			next.release();
		}
		setNext(null);
	}
	
	public void die() {
		ComInt.print("Orangutan.die");ComInt.indent++;
		game.endGame();
	}
}
