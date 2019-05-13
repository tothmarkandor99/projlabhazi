package projlabhazi;

/**
 * @author Mark
 * Törékeny csempe. Ha egy panda ugrik rajta vagy rálép, csökken az élettartama.
 */
public class BreakingTile extends Tile {
	/**
	 * Ennyiszer ugorhat még rajt egy panda vagy léphet rá karakter mielõtt a csempe eltörne
	 */
	private int life;
	
	/**
	 * 20 egységnyi élettartammal kezd a csempe
	 */
	public BreakingTile() {
		
		life = 20;
	}

	/**
	 * Tud-e orángutánt fogadni
	 * Ha igen, csökkenjen az élettartama
	 */
	@Override
	public boolean receive(Orangutan o) {
		
		if (getObject() == null)
			return false;
		setObject(o);
		crack();
		return true;
	}

	/**
	 * Tud-e pandát fogadni
	 * Ha igen, csökkenjen az élettartama
	 */
	@Override
	public boolean receive(Panda p) {// Tud-e pandát fogadni
		
		if (getObject() == null)
			return false;
		setObject(p);
		crack();
		return true;
	}


	/**
	 * A csempe élettartama csökken
	 * Ha eléri a nullát, a csempe eltörik és értesti errõl a rajta álló karaktert
	 */
	public void crack() {
		
		life--;
		if (isBroken()) {
			Break((Character)getObject()); //Csak Character állhat BreakingTile-on
		}
	}
	
	/**
	 * @param c
	 * Aki rajt állt, meghal
	 * Kiveszi a csempét a csempék közül
	 */
	public void Break(Character c) { // Csempe eltörik
		
		c.die();
		for (int i = 0; i < getSides(); i++) {
			getNeighbour(i).removeNeighbour(this);
		}
	}
	
	/**
	 * @return összetört-e a csempe
	 */
	public boolean isBroken() {
		return life == 0;
	}
}
