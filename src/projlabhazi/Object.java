package projlabhazi;

public abstract class Object implements Receiver, Steppable {
	private Tile tile;
	
	@Override
	public boolean receive(Orangutan o) {

	}

	@Override
	public boolean receive(Panda p) {

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
