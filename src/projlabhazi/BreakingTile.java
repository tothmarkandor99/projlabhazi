package projlabhazi;

public class BreakingTile extends Tile {
	private int life;
	
	public BreakingTile() {
		life = 20;
	}
	
	public void print() {  //Teszteléshez TODO: kivenni
		super.print();
	}

	@Override
	public boolean receive(Orangutan o) { // Tud-e orángutánt fogadni
		if (getObject() == null)
			return false;
		setObject(o);
		crack();
		return true;
	}

	@Override
	public boolean receive(Panda p) {// Tud-e pandát fogadni
		if (getObject() == null)
			return false;
		setObject(p);
		crack();
		return true;
	}


	public void crack() { // A csempe kicsit kopik
		life--;
		if (life == 0) {
			Break((Character)getObject()); //Csak Character állhat BreakingTile-on
		}
	}
	
	public void Break(Character c) { // Csempe eltörik
		c.die(); //Aki rajt állt, meghal
		for (int i = 0; i < getSides(); i++) {
			getNeighbour(i).removeNeighbour(this);
		}
	}
	
}
