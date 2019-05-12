package projlabhazi;

import java.util.Random;

public class ChocolateMachine extends Object implements Interact {
	public void beep() { //Minden szomszédjával megpróbál interaktálni 
		
		for (int i = 0; i < tile.getSides(); i++) {
			if (tile.getNeighbour(i).getObject() != null) {
				this.interact(tile.getNeighbour(i).getObject());
			}
		}
	}
	
	public void step() {
		if (new Random().nextBoolean())
			beep();
	}


	public void interact(Object o) { //Ugrásra kényszeríti o-t
		
		o.jump();
	}

}
