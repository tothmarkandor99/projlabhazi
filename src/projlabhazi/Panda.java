package projlabhazi;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Panda extends Character {
	protected Character prev;
	protected Panda next;
	
	public Panda(Game g) {
		super(g);
		prev = null;
	}
	
	public boolean receive(Orangutan o) {
		if (prev == null) {
			o.add(this);
		}
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
			//TODO: teszteléshez kivéve, a pandák ne mozogjanak maguktól
			/*int nextDirection = ThreadLocalRandom.current().nextInt(0, tile.getSides());
			if (tile.put(this, nextDirection)) {
				moveTo(getTile().getNeighbour(nextDirection));
			}*/
		}
	}
	
	@Override
	public void Notify() {
		next.release();
		this.setNext(null);
	}
	
	public void release() { //Rekurzív
		if (next != null) {
			next.release();
		}
		setNext(null);
		setPrev(null);
	}
	
	public void die() {
		if (prev != null) {
			prev.Notify();
		}
		game.getTimer().removeSteppable(this);
		game.pandaDies();
		getTile().setObject(null);
	}
	
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
