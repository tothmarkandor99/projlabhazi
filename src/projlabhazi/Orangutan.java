package projlabhazi;

public class Orangutan extends Character {
	public Orangutan(Game g) {
		super(g);
	}
	
	public void add(Panda p) {
		//TODO: itt kell a swap-et megval�s�tani
		// Orangutan �s panda megcser�l�se
		// El�sz�r a karakterek mez� referenci�it cser�lj�k meg
		Tile tempTile = this.getTile();
		this.setTile(p.getTile());
		p.setTile(tempTile);
		// Azt�n a mez�k karakter referenci�it
		this.getTile().setObject(this);
		p.getTile().setObject(p);
		// �j panda beilleszt�se a pandal�ncba
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
		if (game.getInputSpace() == false) //Tesztel�shez TODO: kivenni
			return; //Tesztel�shez TODO: kivenni
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
