package projlabhazi;

public class Tile implements Receiver {
	private Tile[] neighbours;
	private Object object;
	
	@Override
	public boolean receive(Orangutan o) {
		if (object != null)
			return false;
		object = o;
		return true;
	}

	@Override
	public boolean receive(Panda p) {
		if (object != null)
			return false;
		object = p;
		return true;
	}

	public void removeNeighbour(Tile tile) {
		//TODO: ezt lehet nem így kéne
	}
	
	public boolean put(Character c, int i) {
		return false;
	}
	
	public void crack() { }
	
	public void setObject(Object o) {
		object = o;
	}
	
	public Object getObject() {
		return object;
	}
	
	public int getSides() {
		return neighbours.length;
	}
	
	public Tile getNeighbour(int i) {
		return neighbours[i];
	}
	
}
