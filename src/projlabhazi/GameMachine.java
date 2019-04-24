package projlabhazi;

import java.util.Random;

public class GameMachine extends Object {
	public void ring() { //Minden szomszédjával megpróbál interaktálni 
		ComInt.print("GameMachine.ring");ComInt.indent++;
		for (int i = 0; i < tile.getSides(); i++) {
			if (tile.getNeighbour(i).getObject() != null) {
				this.interact(tile.getNeighbour(i).getObject());
			}
		}
	}
	
	public void interact(Object o) {
		ComInt.print("GameMachine.interact");ComInt.indent++;
		o.scare();
	}


	public void step() {
		ComInt.print("GameMachine.step");ComInt.indent++;
		switch (randomState) {
		case 0:
			ring();
			break;
		case 2:
			if (new Random().nextBoolean())
				ring();
			break;
		default:
			break;
		}
	}
}
