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
	public void Notify() { //Elengedi a m�g�tte �ll� pand�k kez�t �s az el�tte �ll� karakter kez�s
		
		next.release();
		this.setNext(null);
	}
	
	public void release() { //Rekurz�van elengedi az egym�s m�g�tt �ll� pand�k kez�t
		
		if (next != null) {
			next.release();
		}
		setNext(null);
		setPrev(null);
	}
	
	public void die() { // A panda a j�t�k sor�n meghal
		
		if (prev != null) { //A m�g�tte �ll�k elengedik egym�s kez�t
			prev.Notify();
		}
		game.getTimer().removeSteppable(this);
		game.pandaDies();
		getTile().setObject(null);
	}
	
	public void kill() { // A pand�t megsz�mol�s sor�n meg�lj�k. Meg�l�nk a l�ncban minden m�s pand�t is
		
		game.getTimer().removeSteppable(this);
		game.pandaDies();
		if (getPrev() != null)
			getPrev().setNext(null);
		if (getNext() != null)
			getNext().setPrev(null);
		getTile().setObject(null);
	}
}
