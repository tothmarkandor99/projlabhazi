package projlabhazi;

public class Tile implements Receiver {
	private Tile[] neighbours;
	private Object object;
	
	@Override
	public boolean receive(Orangutan o) {

	}

	@Override
	public boolean receive(Panda p) {

	}

	public void removeNeighbour(Tile tile) {
		
	}
	
	public boolean put(Character c, int i) {
		return false;
	}
	
	public void crack() {
		
	}
	
	public void setObject(Object o) {
		object = o;
	}
	
	public Object getObject() {
		return object;
	}
	
	public int getSides() {


	}
	
	public Tile getNeighbour(int i) {
		
	}
	
}
