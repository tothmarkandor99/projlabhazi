package projlabhazi;

import java.util.Random;

public class ChocolateMachine extends Object implements Interact {
	public void beep() { //Minden szomsz�dj�val megpr�b�l interakt�lni 
		ComInt.print("ChocolateMachine.beep");ComInt.indent++;
		for (int i = 0; i < tile.getSides(); i++) {
			if (tile.getNeighbour(i).getObject() != null) {
				this.interact(tile.getNeighbour(i).getObject());
			}
		}
	}
	
	public void step() {
		ComInt.print("ChocolateMachine.step");ComInt.indent++;
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


	public void interact(Object o) { //Ugr�sra k�nyszer�ti o-t
		ComInt.print("ChocolateMachine.interact");ComInt.indent++;
		o.jump();
	}

}
