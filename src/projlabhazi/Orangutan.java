package projlabhazi;

public class Orangutan extends Character {
	public void add(Panda p) {
		p.next = next;
		next = p;
	}
	
	public int countPanda() { //Eltérés a dokumentációhoz képest
		Character temp = next;
		int pcs = 0;
		while (temp != null) {
			pcs++;
			temp = temp.next;
		}
		return pcs;	
	}
	
	public void step() {
		if (tile.put(this, 0)) { //TODO: user input
			this.moveTo(tile.getNeighbour(0)); //TODO: user input
		}
	}
}
