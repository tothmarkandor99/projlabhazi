package projlabhazi;

/**
 * @author Mark
 * Objektum �soszt�ly, tartalmaz egy referenci�t az alatta lev� csemp�re
 */
public abstract class Object implements Receiver, Steppable {
	protected Tile tile;

	/**
	 * Nem tud ugrani
	 */
	public void jump() {
		
	}
	
	/**
	 * Nem tud megijedni
	 */
	public void scare() {
		
	}

	public boolean sleep() {
		
		return false;
	}
	
	public boolean receive(Orangutan o) {
		
		return false;
	}

	public boolean receive(Panda p) {
		
		return false;
	}

	public void setTile(Tile t) {
		
		tile = t;
	}

	public Tile getTile() {
		
		return tile;
	}

	public void step() {
		
	}
	
}
