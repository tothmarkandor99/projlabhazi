package projlabhazi;

/**
 * @author Mark
 * T�r�keny csempe. Ha egy panda ugrik rajta vagy r�l�p, cs�kken az �lettartama.
 */
public class BreakingTile extends Tile {
	/**
	 * Ennyiszer ugorhat m�g rajt egy panda vagy l�phet r� karakter miel�tt a csempe elt�rne
	 */
	private int life;
	
	/**
	 * 20 egys�gnyi �lettartammal kezd a csempe
	 */
	public BreakingTile() {
		
		life = 20;
	}

	/**
	 * Tud-e or�ngut�nt fogadni
	 * Ha igen, cs�kkenjen az �lettartama
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
	 * Tud-e pand�t fogadni
	 * Ha igen, cs�kkenjen az �lettartama
	 */
	@Override
	public boolean receive(Panda p) {// Tud-e pand�t fogadni
		
		if (getObject() == null)
			return false;
		setObject(p);
		crack();
		return true;
	}


	/**
	 * A csempe �lettartama cs�kken
	 * Ha el�ri a null�t, a csempe elt�rik �s �rtesti err�l a rajta �ll� karaktert
	 */
	public void crack() {
		
		life--;
		if (isBroken()) {
			Break((Character)getObject()); //Csak Character �llhat BreakingTile-on
		}
	}
	
	/**
	 * @param c
	 * Aki rajt �llt, meghal
	 * Kiveszi a csemp�t a csemp�k k�z�l
	 */
	public void Break(Character c) { // Csempe elt�rik
		
		c.die();
		for (int i = 0; i < getSides(); i++) {
			getNeighbour(i).removeNeighbour(this);
		}
	}
	
	/**
	 * @return �sszet�rt-e a csempe
	 */
	public boolean isBroken() {
		return life == 0;
	}
}
