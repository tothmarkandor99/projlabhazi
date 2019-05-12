package projlabhazi;

import java.util.Random;

public abstract class Panda extends Character {
	protected Character prev;
	protected Panda next;
	
	public Panda(Game g) {
		super(g);
		
		prev = null;
	}
	
	public boolean receive(Orangutan o) {
		
		o.add(this);
		return false;
	}
	
	public void setPrev(Character c) {
		
		prev = c;
	}
	
	public Character getPrev() {
		
		return prev;
	}
	
	public void step() {
		
		if (prev == null) {
			int nextDirection = new Random().nextInt(tile.getSides());
			if (tile.put(this, nextDirection)) {
				moveTo(getTile().getNeighbour(nextDirection));
			}
		}
	}
	
	@Override
	public void Notify() { //Elengedi a mögötte álló pandák kezét és az elõtte álló karakter kezés
		
		next.release();
		this.setNext(null);
	}
	
	public void release() { //Rekurzívan elengedi az egymás mögött álló pandák kezét
		
		if (next != null) {
			next.release();
		}
		setNext(null);
		setPrev(null);
	}
	
	public void die() { // A panda a játék során meghal
		
		if (prev != null) { //A mögötte állók elengedik egymás kezét
			prev.Notify();
		}
		game.getTimer().removeSteppable(this);
		game.pandaDies();
		getTile().setObject(null);
	}
	
	public void kill() { // A pandát megszámolás során megöljük. Megölünk a láncban minden más pandát is
		
		game.getTimer().removeSteppable(this);
		game.pandaDies();
		if (getPrev() != null)
			getPrev().setNext(null);
		if (getNext() != null)
			getNext().setPrev(null);
		getTile().setObject(null);
	}
}
