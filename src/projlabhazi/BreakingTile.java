package projlabhazi;

public class BreakingTile extends Tile {
	private int life;
	
	@Override
	public boolean receive(Orangutan o) {
		if (getObject() == null)
			return false;
		setObject(o);
		crack();
		return true;
	}

	@Override
	public boolean receive(Panda p) {
		if (getObject() == null)
			return false;
		setObject(p);
		crack();
		return true;
	}


	public void crack() {
		life--;
		if (life == 0) {
			Break((Character)getObject());
		}
	}
	
	public void Break(Character c) {
		c.die();
		for (int i = 0; i < getSides(); i++) {
			getNeighbour(i).removeNeighbour(this);
		}		
	}
	
}
