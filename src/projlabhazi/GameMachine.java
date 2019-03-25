package projlabhazi;

public class GameMachine extends Object {
	public void ring() { //Minden szomsz�dj�val megpr�b�l interakt�lni 
		ComInt.sendMessage("GameMachine.ring");ComInt.indent++;
		for (int i = 0; i < tile.getSides(); i++) {
			if (tile.getNeighbour(i).getObject() != null) {
				this.interact(tile.getNeighbour(i).getObject());
			}
		}
	}
	
	public void interact(Object o) {
		ComInt.sendMessage("GameMachine.interact");ComInt.indent++;
		o.scare();
	}


	public void step() {
		ComInt.sendMessage("GameMachine.step");ComInt.indent++;
		if (true) { //tesztel�shez kiv�ve TODO: random
			this.ring();
		}
	}
}
