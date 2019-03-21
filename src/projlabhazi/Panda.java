package projlabhazi;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Panda extends Character {
	protected Character prev;
	
	public void jump() {}
	
	public void scare() {}
	
	public void sleep() {}
	
	public boolean receive(Orangutan o) {
		o.add(this);
		return true;
	}
	
	public void setPrev(Character c) {
		prev = c;
	}
	
	public Character getPrev() {
		return prev;
	}
	
	public void step() {
		if (prev == null) {
			int nextDirection = ThreadLocalRandom.current().nextInt(0, tile.getSides());
			tile.put(this, nextDirection);
		}
	}
	
	public void Notify() {
		if (next != null) {
			next.release();
			next = null;
		}
	}
	
	public void release() {
		prev = null;
	}
	
	public void die() {
		if (prev != null) {
			prev.Notify();
			//TODO: Timer.removeSteppable(this);
			game.pandaDies();
		}
	}
}
