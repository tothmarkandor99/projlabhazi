package projlabhazi;

public abstract class Character extends Object {
	protected Panda next;
	protected Game game; //Eltér a dokumentációtól
	
	public Character(Game g) {
		ComInt.sendMessage("Character.Character");ComInt.indent++;
		game = g;
	}
	
	public abstract void release();
	
	public void die() {
		ComInt.sendMessage("Character.die");ComInt.indent++;
	}
	
	public void Notify() {
		ComInt.sendMessage("Character.Notify");ComInt.indent++;
		next.release();
		this.setNext(null);
	}
	
	public void moveTo(Tile t) { // A karaktert a t csempére viszi át, feltételezve, hogy szabad odalépnie
		ComInt.sendMessage("Character.moveTo");ComInt.indent++;
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
		ComInt.sendMessage("Character.setNext");ComInt.indent++;
		next = c;
	}
	
	public Panda getNext() {
		ComInt.sendMessage("Character.getNext");ComInt.indent++;
		return next;
	}
}
