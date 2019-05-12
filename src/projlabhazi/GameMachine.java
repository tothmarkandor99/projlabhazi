package projlabhazi;

import java.util.Random;

public class GameMachine extends Object {
	public void ring() { //Minden szomsz�dj�val megpr�b�l interakt�lni 
		
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
		if (new Random().nextBoolean())
			ring();
	}
}
