package projlabhazi;

import java.util.ArrayList;

/**
 * @author Mark
 * Csempe
 * Tárolja a szomszédait és tárolhat egy objektumot is
 * Egyedi azonosítóal kell rendelkeznie, ez fontos a megjelenítés miatt
 */
public class Tile implements Receiver {
	/**
	 * Szomszédos csempék
	 * A szomszédság kölcsönös tulajdonság
	 */
	private ArrayList<Tile> neighbours = new ArrayList<Tile>();
	/**
	 * Csempén álló objektum
	 */
	private Object object;
	/**
	 * Egyedi azonosító
	 */
	public int id;
	
	public Tile() {
		
	}

	/**
	 * Tud-e a csempe orángutánt fogadni
	 * Ha üres, akkor biztosan
	 * Ha nem üres, akkor megnézi, hogy a rajta levõ objektum tud-e orángutánt fogadni (Wardrobe, Exit, némely Panda-k)
	 */
	@Override
	public boolean receive(Orangutan o) {
		
		if (object == null) {
			return true;
		}
		return object.receive(o);
	}

	/**
	 * Panda csak üres mezõre léphet (magától)
	 */
	@Override
	public boolean receive(Panda p) {
		return object == null;
	}

	public void addNeighbour(Tile tile) {
		if (!neighbours.contains(tile)) {
			neighbours.add(tile);
		}
		if (!tile.neighbours.contains(this)) {
			tile.neighbours.add(this);
		}
	}
	
	public void removeNeighbour(Tile tile) {
		if (neighbours.contains(tile)) {
			neighbours.remove(tile);
		}
		if (tile.neighbours.contains(this)) {
			tile.neighbours.remove(this);
		}
	}
	
	/**
	 * @param p
	 * @param i
	 * @return
	 * Megvizsgálja hogy az adott irányban levõ csempére lehet-e pandát tenni
	 */
	public boolean put(Panda p, int i) {
		
		return neighbours.get(i).receive(p);
	}
	
	/**
	 * @param o
	 * @param i
	 * @return
	 * Megvizsgálja hogy az adott irányban levõ csempére lehet-e orángutánt tenni
	 */
	public boolean put(Orangutan o, int i) {
		
		return neighbours.get(i).receive(o);
	}
	
	/**
	 * Sima csempe nem tud eltörni
	 */
	public void crack() {
		
	}

	public void setObject(Object o) {
		
		object = o;
	}

	public Object getObject() {
		
		return object;
	}
	
	/**
	 * @return
	 * Hány szomszédja van
	 */
	public int getSides() {
		
		return neighbours.size();
	}
	
	/**
	 * @param i
	 * @return
	 * Az i. szomszédját adja vissza
	 */
	public Tile getNeighbour(int i) {
		
		return neighbours.get(i);
	}
	
}
