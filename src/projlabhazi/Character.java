package projlabhazi;

public abstract class Character extends Object {
	protected Panda next;
	protected Game game; //Eltér a dokumentációtól
	
	public Character(Game g) {
		game = g;
	}
	
	public abstract void release();
	
	public void die() {	}
	
	public void Notify() {
		next.release();
	}
	
	public void moveTo(Tile t) {
		Tile tempTile = this.getTile();
		this.setTile(t);
		t.setObject(this);
		if (next != null) {
			next.moveTo(tempTile);
		} else {
			tempTile.setObject(null);
		}
	}
	
	public void setNext(Panda c) {
		next = c;
	}
	
	public Panda getNext() {
		return next;
	}
}
