package projlabhazi;

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
		if (true) { //teszteléshez kivéve TODO: random
			beep();
		}
	}


	public void interact(Object o) { //Ugrásra kényszeríti o-t
		ComInt.sendMessage("ChocolateMachine.interact");ComInt.indent++;
		o.jump();
	}

}
