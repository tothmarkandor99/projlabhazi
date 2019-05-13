package projlabhazi;

import java.util.Random;

/**
 * @author Corvinusplusplus
 * Panda �soszt�ly
 * A karakter funkcionalit�s�t azzal b�v�ti ki, hogy van el�z� karakter tulajdons�ga
 */
public abstract class Panda extends Character {
	/**
	 * El�z� karakter a l�ncban
	 */
	protected Character prev;

	public Panda(Game g, Tile tile) {
		super(g);
		this.tile = tile;
		prev = null;
	}
	
	/**
	 * Or�ngut�n pand�ra l�p �s bekapcsolja a saj�t pandal�nc�ba
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
	 * V�letlen ir�nyba l�p
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
	 *Elengedi a m�g�tte �ll� pand�k kez�t �s az el�tte �ll� karakter kez�t
	 */
	@Override
	public void Notify() {
		
		next.release();
		this.setNext(null);
	}
	
	/**
	 * Rekurz�van elengedi az egym�s m�g�tt �ll� pand�k kez�t
	 */
	public void release() {
		
		if (next != null) {
			next.release();
		}
		setNext(null);
		setPrev(null);
	}
	
	/**
	 * A panda a j�t�k sor�n meghal
	 * A m�g�tte �ll�k elengedik egym�s kez�t
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
	 * A pand�t megsz�mol�s sor�n meg�lj�k. Meg�l�nk a l�ncban minden m�s pand�t is
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
