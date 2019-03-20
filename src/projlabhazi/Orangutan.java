package projlabhazi;

public class Orangutan extends Character {
	public void add(Panda p) {
		
	}
	
	public void countPanda() {
		
	}
	
	public void step() {
		if (tile.put(this, 0)) { //TODO: user input
			this.moveTo(tile.getNeighbour(0)); //TODO: user input
		}
	}
}
