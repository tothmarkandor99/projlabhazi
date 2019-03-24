package projlabhazi;

public abstract class Character extends Object {
	protected Character next;
	protected Game game; //Elt�r a dokument�ci�t�l
	
	public Character(Game g) {
		game = g;
	}
	
	public abstract void release();
	
	public void die() {	}
	
	public void Notify() { }
	
	public void moveTo(Tile t) {
		this.setTile(t);
		if (next != null) {
			next.moveTo(tile);
		}
	}
	
	public void setNext(Character c) {
		next = c;
	}
	
	public Character getNext() {
		return next;
	}
}
