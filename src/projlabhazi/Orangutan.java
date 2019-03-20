package projlabhazi;

public class Orangutan extends Character {
	public void add(Panda p) {
		p.next = next;
		next = p;
	}
	
	public void countPanda() {
		Character temp = next;
		int pcs = 0;
		while (temp != null) {
			pcs++;
			temp = temp.next;
		}
	}
	
	public void step() {
		if (tile.put(this, 0)) { //TODO: user input
			this.moveTo(tile.getNeighbour(0)); //TODO: user input
		}
	}
}
