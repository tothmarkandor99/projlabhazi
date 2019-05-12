package projlabhazi;

import java.util.Random;

public class ChocolateMachine extends Object implements Interact {
	public void beep() { //Minden szomsz�dj�val megpr�b�l interakt�lni 
		
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


	public void interact(Object o) { //Ugr�sra k�nyszer�ti o-t
		
		o.jump();
	}

}
