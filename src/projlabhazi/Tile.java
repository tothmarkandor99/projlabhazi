package projlabhazi;

import java.util.ArrayList;

/**
 * @author Corvinusplusplus
 * Csempe
 * T�rolja a szomsz�dait �s t�rolhat egy objektumot is
 * Egyedi azonos�t�al kell rendelkeznie, ez fontos a megjelen�t�s miatt
 */
public class Tile implements Receiver {
	/**
	 * Szomsz�dos csemp�k
	 * A szomsz�ds�g k�lcs�n�s tulajdons�g
	 */
	private ArrayList<Tile> neighbours = new ArrayList<Tile>();
	/**
	 * Csemp�n �ll� objektum
	 */
	private Object object;
	/**
	 * Egyedi azonos�t�
	 */
	public int id;
	
	public Tile() {
		
	}

	/**
	 * Tud-e a csempe or�ngut�nt fogadni
	 * Ha �res, akkor biztosan
	 * Ha nem �res, akkor megn�zi, hogy a rajta lev� objektum tud-e or�ngut�nt fogadni (Wardrobe, Exit, n�mely Panda-k)
	 */
	@Override
	public boolean receive(Orangutan o) {
		
		if (object == null) {
			return true;
		}
		return object.receive(o);
	}

	/**
	 * Panda csak �res mez�re l�phet (mag�t�l)
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
	 * Megvizsg�lja hogy az adott ir�nyban lev� csemp�re lehet-e pand�t tenni
	 */
	public boolean put(Panda p, int i) {
		
		return neighbours.get(i).receive(p);
	}
	
	/**
	 * @param o
	 * @param i
	 * @return
	 * Megvizsg�lja hogy az adott ir�nyban lev� csemp�re lehet-e or�ngut�nt tenni
	 */
	public boolean put(Orangutan o, int i) {
		
		return neighbours.get(i).receive(o);
	}
	
	/**
	 * Sima csempe nem tud elt�rni
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
	 * H�ny szomsz�dja van
	 */
	public int getSides() {
		
		return neighbours.size();
	}
	
	/**
	 * @param i
	 * @return
	 * Az i. szomsz�dj�t adja vissza
	 */
	public Tile getNeighbour(int i) {
		
		return neighbours.get(i);
	}
	
}
