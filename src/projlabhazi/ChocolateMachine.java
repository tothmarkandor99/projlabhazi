package projlabhazi;

import java.util.Random;

public class ChocolateMachine extends Object implements Interact {
	public void beep() { //Minden szomsz�dj�val megpr�b�l interakt�lni 
		ComInt.sendMessage("ChocolateMachine.beep");ComInt.indent++;
		for (int i = 0; i < tile.getSides(); i++) {
			if (tile.getNeighbour(i).getObject() != null) {
				this.interact(tile.getNeighbour(i).getObject());
			}
		}
	}
	
	public void step() { //V�letlen id�k�z�nk�nt
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


	public void interact(Object o) { //Ugr�sra k�nyszer�ti o-t
		ComInt.sendMessage("ChocolateMachine.interact");ComInt.indent++;
		o.jump();
	}

}
