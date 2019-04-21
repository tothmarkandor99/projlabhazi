package projlabhazi;

import java.util.Random;

public class ChocolateMachine extends Object implements Interact {
	public void beep() { //Minden szomszédjával megpróbál interaktálni 
		ComInt.sendMessage("ChocolateMachine.beep");ComInt.indent++;
		for (int i = 0; i < tile.getSides(); i++) {
			if (tile.getNeighbour(i).getObject() != null) {
				this.interact(tile.getNeighbour(i).getObject());
			}
		}
	}
	
	public void step() { //Véletlen idõközönként
		ComInt.sendMessage("ChocolateMachine.step");ComInt.indent++;
		switch (randomState) {
		case 0:
			beep();
			break;
		case 2:
			if (new Random().nextBoolean())
				beep();
			break;
		default:
			break;
		}
	}


	public void interact(Object o) { //Ugrásra kényszeríti o-t
		ComInt.sendMessage("ChocolateMachine.interact");ComInt.indent++;
		o.jump();
	}

}
