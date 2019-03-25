package projlabhazi;

public class GameMachine extends Object {
	public void ring() { //Minden szomszédjával megpróbál interaktálni 
		for (int i = 0; i < tile.getSides(); i++) {
			if (tile.getNeighbour(i).getObject() != null) {
				this.interact(tile.getNeighbour(i).getObject());
			}
		}
	}
	
	public void interact(Object o) {
		o.scare();
	}


	public void step() {
		if (true) { //teszteléshez kivéve TODO: random
			this.ring();
		}
	}
}
