package projlabhazi;

/**
 * @author Mark
 * Karakter �soszt�ly a pand�knak �s az or�ngut�nnak
 */
public abstract class Character extends Object {
	/**
	 * K�vetkez� karakter a l�ncban
	 * Csak valamilyen panda lehet
	 */
	protected Panda next;

	protected Game game;

	public Character(Game g) {
		
		game = g;
	}
	
	/**
	 * Engedje el az el�z� karaktert
	 */
	public abstract void release();
	
	/**
	 * Meghal
	 */
	public abstract void die();
	
	/**
	 * Engedje el a k�vetkez� pand�t
	 */
	public void Notify() {
		
		next.release();
		this.setNext(null);
	}
	
	/**
	 * @param t
	 * A karaktert a t csemp�re viszi �t, felt�telezve, hogy szabad odal�pnie
	 * Rekurz�van l�pteti az ut�na sorban �ll� pand�kat is
	 * Ahol �llt, onnan kiveszi mag�t
	 */
	public void moveTo(Tile t) {
		
		Tile tempTile = this.getTile();
		this.setTile(t);
		t.setObject(this);
		if (next != null) {
			next.moveTo(tempTile);
		} else {
			if (tempTile != null)
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
