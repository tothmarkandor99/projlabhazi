package projlabhazi;

public abstract class Object implements Receiver, Steppable {
	protected Tile tile;
	
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
}
