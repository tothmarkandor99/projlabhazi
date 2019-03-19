package projlabhazi;

public abstract class Character extends Object {
	protected Character next;
	private Game game;
	
	public void release() {
		
	}
	
	public void die() {
		
	}
	
	public void Notify() {
		
	}
	
	public void moveTo(Tile t) {
		
	}
	
	public void setNext(Character c) {
		next = c;
	}
	
	public Character getNext() {
		return next;
	}
}
