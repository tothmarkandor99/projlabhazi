package projlabhazi;

public class Tile implements Receiver {
	private Tile[] neighbours;
	private Object object;
	
	@Override
	public boolean receive(Orangutan o) {
		if (object == null)
			return false;
		object = o;
		return true;
	}

	@Override
	public boolean receive(Panda p) {
		if (object == null)
			return false;
		object = p;
		return true;
	}

	public void removeNeighbour(Tile tile) { //TODO: ezt lehet nem így kéne
		int i = 0;
		while (i < neighbours.length && neighbours[i] != tile) {
			i++;
		}
		if (i != neighbours.length) { //Found 
			Tile[] newNeighbours = new Tile[neighbours.length - 1];
			for (int j = 0; j < newNeighbours.length; j++) { //Copy except the parameter tile
				newNeighbours[j] = neighbours[j + j >= i ? 1 : 0];
			}
			neighbours = newNeighbours;
		}
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
