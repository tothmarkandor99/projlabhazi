package projlabhazi;

public class GameMachine extends Object {
	public void ring() {
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
		//TODO: random
		if (true) { //TODO: random
			this.ring();
		}
	}
}
