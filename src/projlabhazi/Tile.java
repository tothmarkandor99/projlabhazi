package projlabhazi;

public class Tile implements Receiver {
	private Tile[] neighbours = new Tile[0];
	private Object object;
	
	public void print() {  //Teszteléshez TODO: kivenni
		if (object == null) {
			System.out.print("üres");
		} else {
			System.out.print(object.getClass() + "\t" + (object.getTile() == null ? "üres" : "Tile"));
		}
	}
	
	@Override
	public boolean receive(Orangutan o) {
		if (object == null) {
			setObject(o);
			return true;
		}
		return object.receive(o);
	}

	@Override
	public boolean receive(Panda p) {
		if (object == null)
			return false;
		return object.receive(p);
	}

	public void addNeighbour(Tile tile) { //Ez nem volt benn a dokumentációban
		//TODO: ArrayListre-átalakítani
		Tile[] newNeighbours = new Tile[neighbours.length + 1];
		for (int i = 0; i < neighbours.length; i++) {
			newNeighbours[i] = neighbours[i];
		}
		newNeighbours[newNeighbours.length - 1] = tile;
		neighbours = newNeighbours;
	}
	
	public void removeNeighbour(Tile tile) { //TODO: ArrayListre-átalakítani
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
	
	public boolean put(Panda p, int i) {
		if (neighbours[i].receive(p)) {
			setObject(null);
			return true;
		}
		return false;
	}
	
	public boolean put(Orangutan o, int i) {
		if (neighbours[i].receive(o)) {
			setObject(null);
			return true;
		}
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
