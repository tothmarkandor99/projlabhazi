package projlabhazi;

public class Tile implements Receiver {
	private Tile[] neighbours = new Tile[0];
	private Object object;
	
	public void print() {  //Teszteléshez TODO: kivenni
		if (object == null) {
			System.out.println("üres");
		} else {
			System.out.println(object.getClass());
		}
	}
	
	@Override
	public boolean receive(Orangutan o) {
		if (object == null)
			return false;
		return object.receive(o);
	}

	@Override
	public boolean receive(Panda p) {
		if (object == null)
			return false;
		return object.receive(p);
	}

	public void addNeighbour(Tile tile) { //Ez nem volt benn a dokumentációban
		Tile[] newNeighbours = new Tile[neighbours.length + 1];
		for (int i = 0; i < neighbours.length; i++) {
			newNeighbours[i] = neighbours[i];
		}
		newNeighbours[newNeighbours.length - 1] = tile;
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
	
	public boolean put(Character c, int i) { //TODO: ez így biztos nem lesz jó
		if (c instanceof Panda)
			return neighbours[i].receive((Panda)c);
		if (c instanceof Orangutan)
			return neighbours[i].receive((Orangutan)c);
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
