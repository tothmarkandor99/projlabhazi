package projlabhazi;

public class ChocolateMachine extends Object implements Interact {
	public void beep() { //Minden szomsz�dj�val megpr�b�l interakt�lni 
		for (int i = 0; i < tile.getSides(); i++) {
			if (tile.getNeighbour(i).getObject() != null) {
				this.interact(tile.getNeighbour(i).getObject());
			}
		}
	}
	
	public void step() { //V�letlen id�k�z�nk�nt
		if (true) { //tesztel�shez kiv�ve TODO: random
			beep();
		}
	}


	public void interact(Object o) { //Ugr�sra k�nyszer�ti o-t
		o.jump();
	}

}
