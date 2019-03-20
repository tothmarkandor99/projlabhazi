package projlabhazi;

public abstract class Object implements Receiver, Steppable {
	protected Tile tile;
	
	public abstract boolean receive(Orangutan o);

	public abstract boolean receive(Panda p);

	public void setTile(Tile t) {
		tile = t;
	}
	
	public Tile getTile() {
		return tile;
	}

	public abstract void step();
}
