package projlabhazi;

public class Orangutan extends Character {
	public Orangutan(Game g) {
		super(g);
	}
	
	public void add(Panda p) {
		p.next = next;
		next = p;
	}
	
	public void countPanda() { //Eltérés a dokumentációhoz képest
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
		if (game.getLastInput() == -1) //Teszteléshez TODO: kivenni
			return; //Teszteléshez TODO: kivenni
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
