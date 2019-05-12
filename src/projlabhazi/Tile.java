package projlabhazi;

import java.util.ArrayList;

public class Tile implements Receiver {
	private ArrayList<Tile> neighbours = new ArrayList<Tile>();
	private Object object;
	public int id;
	
	public Tile() {
		
	}

	@Override
	public boolean receive(Orangutan o) { // Tud-e a csempe orángutánt fogadni
		
		if (object == null) {
			return true; // Ha üres, akkor biztosan
		}
		return object.receive(o); // Ha nem üres, akkor megnézi, hogy a rajta levõ objektum tud-e orángutánt fogadni (Wardrobe, Exit, némely Panda-k)
	}

	@Override
	public boolean receive(Panda p) {// Tud-e a csempe pandát fogadni
		return object == null; // Panda csak üres mezõre léphet (magától)
	}

	public void addNeighbour(Tile tile) { //Ez nem volt benn a dokumentációban
		if (!neighbours.contains(tile)) {
			neighbours.add(tile);
		}
		if (!tile.neighbours.contains(this)) {
			tile.neighbours.add(this);
		}
	}
	
	public void removeNeighbour(Tile tile) { //TODO: ArrayListre-átalakítani, akkor nem lesz ilyen bonyolult
		if (neighbours.contains(tile)) {
			neighbours.remove(tile);
		}
		if (tile.neighbours.contains(this)) {
			tile.neighbours.remove(this);
		}
	}
	
	public boolean put(Panda p, int i) { //Megvizsgálja hogy az adott irányban levõ csempére lehet-e pandát tenni
		
		return neighbours.get(i).receive(p);
	}
	
	public boolean put(Orangutan o, int i) { //Megvizsgálja hogy az adott irányban levõ csempére lehet-e orángutánt tenni
		
		return neighbours.get(i).receive(o);
	}
	
	public void crack() {
		
	} // Sima csempe nem tud eltörni
	
	public void setObject(Object o) {
		
		object = o;
	}
	
	public Object getObject() {
		
		return object;
	}
	
	public int getSides() { // Hány szomszédja van
		
		return neighbours.size();
	}
	
	public Tile getNeighbour(int i) { // Az i. szomszédját adja vissza
		
		return neighbours.get(i);
	}
	
}
