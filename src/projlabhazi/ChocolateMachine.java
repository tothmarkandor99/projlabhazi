package projlabhazi;

public class ChocolateMachine extends Object implements Interact {
	public void beep() { //TODO: Ez különbözõképpen van két szekvenciadiagrammon
		for (int i = 0; i < tile.getSides(); i++) {
			if (tile.getNeighbour(i).getObject() instanceof ChocolatePanda) {
				((ChocolatePanda)tile.getNeighbour(i).getObject()).jump();
			}
		}
	}
	
	public void step() {
		//TODO: random
		if (true) { //TODO: random
			for (int i = 0; i < tile.getSides(); i++) {
				if (tile.getNeighbour(i).getObject() != null) {
					this.interact(tile.getNeighbour(i).getObject());
				}
			}
		}
	}

	@Override
	public void interact(Object o) {}

	@Override
	public void interact(Panda p) {
		p.jump();
	}

}
