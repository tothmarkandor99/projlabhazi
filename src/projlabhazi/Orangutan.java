package projlabhazi;

public class Orangutan extends Character {
	public void add(Panda p) {
		p.next = next;
		next = p;
	}
	
	public void countPanda() { //Elt�r�s a dokument�ci�hoz k�pest
		Character temp = next;
		int pcs = 0;
		while (temp != null) {
			pcs++;
			Character tempNext = temp.getNext();
			temp.die();
			temp = tempNext;
		}
		game.addScore();
		game.toStart();
	}
	
	public void step() {
		if (tile.put(this, 0)) { //TODO: user input
			this.moveTo(tile.getNeighbour(0)); //TODO: user input
		}
	}
	
	public void release() {
		if (next != null) {
			next.release();
		}
		next = null;
	}
}
