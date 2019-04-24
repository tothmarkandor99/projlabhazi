package projlabhazi;

public class Tile implements Receiver {
	private Tile[] neighbours = new Tile[0];
	private Object object;
	public int id; // teszteléshez TODO: kivenni
	
	public Tile() {
		ComInt.println("Tile.Tile");ComInt.indent++;
	}
	
	public void print() {  //Teszteléshez TODO: kivenni
		ComInt.println("Tile.print");ComInt.indent++;
		if (object == null) {
			ComInt.print("\t" + id + " üres");
		} else {
			ComInt.print("\t" + id + " " + object.getClass());
		}
	}
	
	@Override
	public boolean receive(Orangutan o) { // Tud-e a csempe orángutánt fogadni
		ComInt.println("Tile.receive");ComInt.indent++;
		if (object == null) {
			return true; // Ha üres, akkor biztosan
		}
		return object.receive(o); // Ha nem üres, akkor megnézi, hogy a rajta levõ objektum tud-e orángutánt fogadni (Wardrobe, Exit, némely Panda-k)
	}

	@Override
	public boolean receive(Panda p) {// Tud-e a csempe pandát fogadni
		ComInt.println("Tile.receive");
		return object == null; // Panda csak üres mezõre léphet (magától)
	}

	public void addNeighbour(Tile tile) { //Ez nem volt benn a dokumentációban
		ComInt.println("Tile.addNeighbour");ComInt.indent++;
		//TODO: ArrayListre-átalakítani, akkor nem lesz ilyen bonyolult
		Tile[] newNeighbours = new Tile[neighbours.length + 1];
		for (int i = 0; i < neighbours.length; i++) {
			newNeighbours[i] = neighbours[i];
		}
		newNeighbours[newNeighbours.length - 1] = tile;
		neighbours = newNeighbours;
	}
	
	public void removeNeighbour(Tile tile) { //TODO: ArrayListre-átalakítani, akkor nem lesz ilyen bonyolult
		ComInt.println("Tile.removeNeighbour");ComInt.indent++;
		int i = 0;
		while (i < neighbours.length && neighbours[i] != tile) {
			i++;
		}
		if (i != neighbours.length) { //Megtaláltuk 
			Tile[] newNeighbours = new Tile[neighbours.length - 1];
			for (int j = 0; j < newNeighbours.length; j++) { //Copy except the parameter tile
				newNeighbours[j] = neighbours[j + j >= i ? 1 : 0];
			}
			neighbours = newNeighbours;
		}
	}
	
	public boolean put(Panda p, int i) { //Megvizsgálja hogy az adott irányban levõ csempére lehet-e pandát tenni
		ComInt.println("Tile.put");ComInt.indent++;
		return neighbours[i].receive(p);
	}
	
	public boolean put(Orangutan o, int i) { //Megvizsgálja hogy az adott irányban levõ csempére lehet-e orángutánt tenni
		ComInt.println("Tile.put");ComInt.indent++;
		return neighbours[i].receive(o);
	}
	
	public void crack() {
		ComInt.println("Tile.crack");ComInt.indent++;
	} // Sima csempe nem tud eltörni
	
	public void setObject(Object o) {
		ComInt.println("Tile.setObject");ComInt.indent++;
		object = o;
	}
	
	public Object getObject() {
		ComInt.println("Tile.getObject");ComInt.indent++;
		return object;
	}
	
	public int getSides() { // Hány szomszédja van
		ComInt.println("Tile.getSides");ComInt.indent++;
		return neighbours.length;
	}
	
	public Tile getNeighbour(int i) { // Az i. szomszédját adja vissza
		ComInt.println("Tile.getNeighbour");ComInt.indent++;
		return neighbours[i];
	}
	
}
