package projlabhazi;

public abstract class Object implements Receiver, Steppable {
	protected Tile tile;
	protected int randomState = 0; // 0-on, 1-off, 2-random TODO: enum-ra cserélni

	public void jump() {
		ComInt.println("Object.jump");ComInt.indent++;
	}
	
	public void scare() {
		ComInt.println("Object.scare");ComInt.indent++;
	}
	
	public boolean sleep() {
		ComInt.println("Object.sleep");ComInt.indent++;
		return false;
	}
	
	public boolean receive(Orangutan o) {
		ComInt.println("Object.receive");ComInt.indent++;
		return false;
	}

	public boolean receive(Panda p) {
		ComInt.println("Object.receive");ComInt.indent++;
		return false;
	}

	public void setTile(Tile t) {
		ComInt.println("Object.setTile");ComInt.indent++;
		tile = t;
	}
	
	public Tile getTile() {
		ComInt.println("Object.getTile");ComInt.indent++;
		return tile;
	}

	public void step() {
		ComInt.println("Object.step");ComInt.indent++;
	}
	
	public void setRandomState(int randomState) {
		ComInt.println("Object.setRandomState");ComInt.indent++;
		switch (randomState) {
		case 0:
			this.randomState = 0;
			break;
		case 1:
			this.randomState = 1;
			break;
		case 2:
			this.randomState = 2;
			break;
		default:
			break;
		}
	}
}
