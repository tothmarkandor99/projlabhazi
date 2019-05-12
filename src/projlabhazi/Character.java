package projlabhazi;

public abstract class Character extends Object {
	protected Panda next;
	protected Game game; //Eltér a dokumentációtól
	
	public Character(Game g) {
		
		game = g;
	}
	
	public abstract void release();
	
	public void die() {
		
	}
	
	public void Notify() {
		
		next.release();
		this.setNext(null);
	}
	
	public void moveTo(Tile t) { // A karaktert a t csempére viszi át, feltételezve, hogy szabad odalépnie
		
		Tile tempTile = this.getTile();
		this.setTile(t);
		t.setObject(this);
		if (next != null) {
			next.moveTo(tempTile); // Rekurzívan lépteti az utána sorban álló pandákat is
		} else {
			if (tempTile != null)
				tempTile.setObject(null); //Ahol állt, onnan kiveszi magát
		}
	}
	
	public void setNext(Panda c) {
		
		next = c;
	}
	
	public Panda getNext() {
		
		return next;
	}
}
