package projlabhazi;

public abstract class Object implements Receiver, Steppable {
	protected Tile tile;
	protected int randomState = 0; // 0-on, 1-off, 2-random TODO: enum-ra cserélni

	public void jump() {
		ComInt.sendMessage("Object.jump");ComInt.indent++;
	}
	
	public void scare() {
		ComInt.sendMessage("Object.scare");ComInt.indent++;
	}
	
	public boolean sleep() {
		ComInt.sendMessage("Object.sleep");ComInt.indent++;
		return false;
	}
	
	public boolean receive(Orangutan o) {
		ComInt.sendMessage("Object.receive");ComInt.indent++;
		return false;
	}

	public boolean receive(Panda p) {
		ComInt.sendMessage("Object.receive");ComInt.indent++;
		return false;
	}

	public void setTile(Tile t) {
		ComInt.sendMessage("Object.setTile");ComInt.indent++;
		tile = t;
	}
	
	public Tile getTile() {
		ComInt.sendMessage("Object.getTile");ComInt.indent++;
		return tile;
	}

	public void step() {
		ComInt.sendMessage("Object.step");ComInt.indent++;
	}
	
	public void setRandomState(int randomState) {
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
