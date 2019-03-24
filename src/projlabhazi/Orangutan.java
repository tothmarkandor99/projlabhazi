package projlabhazi;

public class Orangutan extends Character {
	public Orangutan(Game g) {
		super(g);
	}
	
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
		if (game.getLastInput() == -1) //Tesztel�shez TODO: kivenni
			return; //Tesztel�shez TODO: kivenni
		if (tile.put(this, game.getLastInput())) { //TODO: user input
			this.moveTo(tile.getNeighbour(game.getLastInput())); //TODO: user input
			game.simulateInput(-1);
		}
	}
	
	public void release() {
		if (next != null) {
			next.release();
		}
		next = null;
	}
}
