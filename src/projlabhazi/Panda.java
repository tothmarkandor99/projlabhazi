package projlabhazi;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Panda extends Character {
	protected Character prev;
	
	public void jump() {}
	
	public void scare() {}
	
	public void sleep() {}
	
	public Panda(Game g) {
		super(g);
		prev = null;
	}
	
	public boolean receive(Orangutan o) {
		if (next == null) {
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
			//TODO: tesztel�shez kiv�ve, a pand�k ne mozogjanak magukt�l
			//int nextDirection = ThreadLocalRandom.current().nextInt(0, tile.getSides());
			//tile.put(this, nextDirection);
		}
	}
	
	@Override
	public void Notify() {
		next.release();
		this.setNext(null);
	}
	
	public void release() { //Rekurz�v
		if (next != null) {
			next.release();
		}
		setNext(null);
		setPrev(null);
	}
	
	public void die() {
		if (prev != null) {
			prev.Notify();
			game.getTimer().removeSteppable(this);
			game.pandaDies();
		}
	}
}
