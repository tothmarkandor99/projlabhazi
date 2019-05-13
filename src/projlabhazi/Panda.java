package projlabhazi;

import java.util.Random;

/**
 * @author Corvinusplusplus
 * Panda õsosztály
 * A karakter funkcionalitását azzal bõvíti ki, hogy van elõzõ karakter tulajdonsága
 */
public abstract class Panda extends Character {
	/**
	 * Elõzõ karakter a láncban
	 */
	protected Character prev;

	public Panda(Game g, Tile tile) {
		super(g);
		this.tile = tile;
		prev = null;
	}
	
	/**
	 * Orángután pandára lép és bekapcsolja a saját pandaláncába
	 */
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
	
	/**
	 * Véletlen irányba lép
	 */
	public void step() {
		
		if (prev == null) {
			int nextDirection = new Random().nextInt(this.tile.getSides());
			if (tile.put(this, nextDirection)) {
				moveTo(getTile().getNeighbour(nextDirection));
			}
		}
	}
	
	/**
	 *Elengedi a mögötte álló pandák kezét és az elõtte álló karakter kezét
	 */
	@Override
	public void Notify() {
		
		next.release();
		this.setNext(null);
	}
	
	/**
	 * Rekurzívan elengedi az egymás mögött álló pandák kezét
	 */
	public void release() {
		
		if (next != null) {
			next.release();
		}
		setNext(null);
		setPrev(null);
	}
	
	/**
	 * A panda a játék során meghal
	 * A mögötte állók elengedik egymás kezét
	 */
	public void die() {
		
		if (prev != null) {
			prev.Notify();
		}
		game.getTimer().removeSteppable(this);
		game.pandaDies();
		getTile().setObject(null);
	}
	
	/**
	 * A pandát megszámolás során megöljük. Megölünk a láncban minden más pandát is
	 */
	public void kill() {
		
		game.getTimer().removeSteppable(this);
		game.pandaDies();
		if (getPrev() != null)
			getPrev().setNext(null);
		if (getNext() != null)
			getNext().setPrev(null);
		getTile().setObject(null);
	}
}
