package projlabhazi;

/**
 * @author Mark
 * Karakter õsosztály a pandáknak és az orángutánnak
 */
public abstract class Character extends Object {
	/**
	 * Következõ karakter a láncban
	 * Csak valamilyen panda lehet
	 */
	protected Panda next;

	protected Game game;

	public Character(Game g) {
		
		game = g;
	}
	
	/**
	 * Engedje el az elõzõ karaktert
	 */
	public abstract void release();
	
	/**
	 * Meghal
	 */
	public abstract void die();
	
	/**
	 * Engedje el a következõ pandát
	 */
	public void Notify() {
		
		next.release();
		this.setNext(null);
	}
	
	/**
	 * @param t
	 * A karaktert a t csempére viszi át, feltételezve, hogy szabad odalépnie
	 * Rekurzívan lépteti az utána sorban álló pandákat is
	 * Ahol állt, onnan kiveszi magát
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
