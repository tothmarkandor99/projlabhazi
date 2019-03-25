package projlabhazi;

public class BreakingTile extends Tile {
	private int life;
	
	public BreakingTile() {
		ComInt.sendMessage("BreakingTile.BreakingTile");ComInt.indent++;
		life = 20;
	}
	
	public void print() {  //Tesztel�shez TODO: kivenni
		ComInt.sendMessage("BreakingTile.print");ComInt.indent++;
		super.print();
	}

	@Override
	public boolean receive(Orangutan o) { // Tud-e or�ngut�nt fogadni
		ComInt.sendMessage("BreakingTile.receive");ComInt.indent++;
		if (getObject() == null)
			return false;
		setObject(o);
		crack();
		return true;
	}

	@Override
	public boolean receive(Panda p) {// Tud-e pand�t fogadni
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
			Break((Character)getObject()); //Csak Character �llhat BreakingTile-on
		}
	}
	
	public void Break(Character c) { // Csempe elt�rik
		ComInt.sendMessage("BreakingTile.Break");ComInt.indent++;
		c.die(); //Aki rajt �llt, meghal
		for (int i = 0; i < getSides(); i++) {
			getNeighbour(i).removeNeighbour(this);
		}
	}
	
}
