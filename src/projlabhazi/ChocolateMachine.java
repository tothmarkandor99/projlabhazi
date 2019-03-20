package projlabhazi;

public class ChocolateMachine extends Object implements Interact{
	public void beep() {
		for (int i = 0; i < tile.getSides(); i++) {
			if (tile.getNeighbour(i).getObject() instanceof ChocolatePanda) {
				((ChocolatePanda)tile.getNeighbour(i).getObject()).jump();
			}
		}
	}
	
	public void step() {
		
	}

	@Override
	public void interact(Object o) {
		
	}

	@Override
	public void interact(Panda p) {
		
	}

	@Override
	public boolean receive(Orangutan o) {

	}

	@Override
	public boolean receive(Panda p) {

	}
}
