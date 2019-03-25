package projlabhazi;

public class ChocolateMachine extends Object implements Interact {
	public void beep() { //Minden szomszédjával megpróbál interaktálni 
		for (int i = 0; i < tile.getSides(); i++) {
			if (tile.getNeighbour(i).getObject() != null) {
				this.interact(tile.getNeighbour(i).getObject());
			}
		}
	}
	
	public void step() { //Véletlen idõközönként
		if (true) { //teszteléshez kivéve TODO: random
			beep();
		}
	}


	public void interact(Object o) { //Ugrásra kényszeríti o-t
		o.jump();
	}

}
