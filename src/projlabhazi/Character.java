package projlabhazi;

public abstract class Character extends Object {
	protected Panda next;
	protected Game game; //Elt�r a dokument�ci�t�l
	
	public Character(Game g) {
		ComInt.print("Character.Character");ComInt.indent++;
		game = g;
	}
	
	public abstract void release();
	
	public void die() {
		ComInt.print("Character.die");ComInt.indent++;
	}
	
	public void Notify() {
		ComInt.print("Character.Notify");ComInt.indent++;
		next.release();
		this.setNext(null);
	}
	
	public void moveTo(Tile t) { // A karaktert a t csemp�re viszi �t, felt�telezve, hogy szabad odal�pnie
		ComInt.print("Character.moveTo");ComInt.indent++;
		Tile tempTile = this.getTile();
		this.setTile(t);
		t.setObject(this);
		if (next != null) {
			next.moveTo(tempTile); // Rekurz�van l�pteti az ut�na sorban �ll� pand�kat is
		} else {
			if (tempTile != null)
				tempTile.setObject(null); //Ahol �llt, onnan kiveszi mag�t
		}
	}
	
	public void setNext(Panda c) {
		ComInt.print("Character.setNext");ComInt.indent++;
		next = c;
	}
	
	public Panda getNext() {
		ComInt.print("Character.getNext");ComInt.indent++;
		return next;
	}
}
