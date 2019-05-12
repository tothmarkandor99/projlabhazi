package projlabhazi;

import java.util.ArrayList;

public class Tile implements Receiver {
	private ArrayList<Tile> neighbours = new ArrayList<Tile>();
	private Object object;
	public int id;
	
	public Tile() {
		
	}

	@Override
	public boolean receive(Orangutan o) { // Tud-e a csempe or�ngut�nt fogadni
		
		if (object == null) {
			return true; // Ha �res, akkor biztosan
		}
		return object.receive(o); // Ha nem �res, akkor megn�zi, hogy a rajta lev� objektum tud-e or�ngut�nt fogadni (Wardrobe, Exit, n�mely Panda-k)
	}

	@Override
	public boolean receive(Panda p) {// Tud-e a csempe pand�t fogadni
		return object == null; // Panda csak �res mez�re l�phet (mag�t�l)
	}

	public void addNeighbour(Tile tile) { //Ez nem volt benn a dokument�ci�ban
		if (!neighbours.contains(tile)) {
			neighbours.add(tile);
		}
		if (!tile.neighbours.contains(this)) {
			tile.neighbours.add(this);
		}
	}
	
	public void removeNeighbour(Tile tile) { //TODO: ArrayListre-�talak�tani, akkor nem lesz ilyen bonyolult
		if (neighbours.contains(tile)) {
			neighbours.remove(tile);
		}
		if (tile.neighbours.contains(this)) {
			tile.neighbours.remove(this);
		}
	}
	
	public boolean put(Panda p, int i) { //Megvizsg�lja hogy az adott ir�nyban lev� csemp�re lehet-e pand�t tenni
		
		return neighbours.get(i).receive(p);
	}
	
	public boolean put(Orangutan o, int i) { //Megvizsg�lja hogy az adott ir�nyban lev� csemp�re lehet-e or�ngut�nt tenni
		
		return neighbours.get(i).receive(o);
	}
	
	public void crack() {
		
	} // Sima csempe nem tud elt�rni
	
	public void setObject(Object o) {
		
		object = o;
	}
	
	public Object getObject() {
		
		return object;
	}
	
	public int getSides() { // H�ny szomsz�dja van
		
		return neighbours.size();
	}
	
	public Tile getNeighbour(int i) { // Az i. szomsz�dj�t adja vissza
		
		return neighbours.get(i);
	}
	
}
