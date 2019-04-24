package projlabhazi;

public class Tile implements Receiver {
	private Tile[] neighbours = new Tile[0];
	private Object object;
	public int id; // tesztel�shez TODO: kivenni
	
	public Tile() {
		ComInt.println("Tile.Tile");ComInt.indent++;
	}
	
	public void print() {  //Tesztel�shez TODO: kivenni
		ComInt.println("Tile.print");ComInt.indent++;
		if (object == null) {
			ComInt.print("\t" + id + " �res");
		} else {
			ComInt.print("\t" + id + " " + object.getClass());
		}
	}
	
	@Override
	public boolean receive(Orangutan o) { // Tud-e a csempe or�ngut�nt fogadni
		ComInt.println("Tile.receive");ComInt.indent++;
		if (object == null) {
			return true; // Ha �res, akkor biztosan
		}
		return object.receive(o); // Ha nem �res, akkor megn�zi, hogy a rajta lev� objektum tud-e or�ngut�nt fogadni (Wardrobe, Exit, n�mely Panda-k)
	}

	@Override
	public boolean receive(Panda p) {// Tud-e a csempe pand�t fogadni
		ComInt.println("Tile.receive");
		return object == null; // Panda csak �res mez�re l�phet (mag�t�l)
	}

	public void addNeighbour(Tile tile) { //Ez nem volt benn a dokument�ci�ban
		ComInt.println("Tile.addNeighbour");ComInt.indent++;
		//TODO: ArrayListre-�talak�tani, akkor nem lesz ilyen bonyolult
		Tile[] newNeighbours = new Tile[neighbours.length + 1];
		for (int i = 0; i < neighbours.length; i++) {
			newNeighbours[i] = neighbours[i];
		}
		newNeighbours[newNeighbours.length - 1] = tile;
		neighbours = newNeighbours;
	}
	
	public void removeNeighbour(Tile tile) { //TODO: ArrayListre-�talak�tani, akkor nem lesz ilyen bonyolult
		ComInt.println("Tile.removeNeighbour");ComInt.indent++;
		int i = 0;
		while (i < neighbours.length && neighbours[i] != tile) {
			i++;
		}
		if (i != neighbours.length) { //Megtal�ltuk 
			Tile[] newNeighbours = new Tile[neighbours.length - 1];
			for (int j = 0; j < newNeighbours.length; j++) { //Copy except the parameter tile
				newNeighbours[j] = neighbours[j + j >= i ? 1 : 0];
			}
			neighbours = newNeighbours;
		}
	}
	
	public boolean put(Panda p, int i) { //Megvizsg�lja hogy az adott ir�nyban lev� csemp�re lehet-e pand�t tenni
		ComInt.println("Tile.put");ComInt.indent++;
		return neighbours[i].receive(p);
	}
	
	public boolean put(Orangutan o, int i) { //Megvizsg�lja hogy az adott ir�nyban lev� csemp�re lehet-e or�ngut�nt tenni
		ComInt.println("Tile.put");ComInt.indent++;
		return neighbours[i].receive(o);
	}
	
	public void crack() {
		ComInt.println("Tile.crack");ComInt.indent++;
	} // Sima csempe nem tud elt�rni
	
	public void setObject(Object o) {
		ComInt.println("Tile.setObject");ComInt.indent++;
		object = o;
	}
	
	public Object getObject() {
		ComInt.println("Tile.getObject");ComInt.indent++;
		return object;
	}
	
	public int getSides() { // H�ny szomsz�dja van
		ComInt.println("Tile.getSides");ComInt.indent++;
		return neighbours.length;
	}
	
	public Tile getNeighbour(int i) { // Az i. szomsz�dj�t adja vissza
		ComInt.println("Tile.getNeighbour");ComInt.indent++;
		return neighbours[i];
	}
	
}
