package projlabhazi;

public class BreakingTile extends Tile {
	private int life;
	
	public BreakingTile() {
		
		life = 20;
	}

	@Override
	public boolean receive(Orangutan o) { // Tud-e or�ngut�nt fogadni
		
		if (getObject() == null)
			return false;
		setObject(o);
		crack();
		return true;
	}

	@Override
	public boolean receive(Panda p) {// Tud-e pand�t fogadni
		
		if (getObject() == null)
			return false;
		setObject(p);
		crack();
		return true;
	}


	public void crack() { // A csempe kicsit kopik
		
		life--;
		if (isBroken()) {
			Break((Character)getObject()); //Csak Character �llhat BreakingTile-on
		}
	}
	
	public void Break(Character c) { // Csempe elt�rik
		
		c.die(); //Aki rajt �llt, meghal
		for (int i = 0; i < getSides(); i++) {
			getNeighbour(i).removeNeighbour(this);
		}
	}
	
	public boolean isBroken() {
		return life == 0;
	}
}
