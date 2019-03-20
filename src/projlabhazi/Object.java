package projlabhazi;

public abstract class Object implements Receiver, Steppable {
	protected Tile tile;
	
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

	public void step() {}
}
