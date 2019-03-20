package projlabhazi;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Panda extends Character {
	protected Character prev;
	
	public void jump() {
		
	}
	
	public void scare() {
		
	}
	
	public void sleep() {
		
	}
	
	public boolean receive(Orangutan o) {
		
	}
	
	public void setPrev(Character c) {
		prev = c;
	}
	
	public Character getPrev() {
		return prev;
	}
	
	public void step() { //TODO: Mi?
		if (prev == null) {
			int nextDirection = ThreadLocalRandom.current().nextInt(0, tile.getSides());
			tile.put(this, nextDirection);
		}
	}
}
