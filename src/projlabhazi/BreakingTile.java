package projlabhazi;

public class BreakingTile extends Tile {
	private int life;
	
	public BreakingTile() {
		ComInt.sendMessage("BreakingTile.BreakingTile");ComInt.indent++;
		life = 20;
	}
	
	public void print() {  //Teszteléshez TODO: kivenni
		ComInt.sendMessage("BreakingTile.print");ComInt.indent++;
		super.print();
	}

	@Override
	public boolean receive(Orangutan o) { // Tud-e orángutánt fogadni
		ComInt.sendMessage("BreakingTile.receive");ComInt.indent++;
		if (getObject() == null)
			return false;
		setObject(o);
		crack();
		return true;
	}

	@Override
	public boolean receive(Panda p) {// Tud-e pandát fogadni
		ComInt.sendMessage("BreakingTile.receive");ComInt.indent++;
		if (getObject() == null)
			return false;
		setObject(p);
		crack();
		return true;
	}


	public void crack() { // A csempe kicsit kopik
		ComInt.sendMessage("BreakingTile.crack");ComInt.indent++;
		life--;
		if (life == 0) {
			Break((Character)getObject()); //Csak Character állhat BreakingTile-on
		}
	}
	
	public void Break(Character c) { // Csempe eltörik
		ComInt.sendMessage("BreakingTile.Break");ComInt.indent++;
		c.die(); //Aki rajt állt, meghal
		for (int i = 0; i < getSides(); i++) {
			getNeighbour(i).removeNeighbour(this);
		}
	}
	
}
