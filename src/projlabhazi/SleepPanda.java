package projlabhazi;

import java.util.Random;

/**
 * @author Corvinusplusplus
 * Aluszékony panda
 * A karosszék képes alvásra csábítani
 * Ekkor az alvási idõ lejártáig nem mozdul a karosszékbõl
 */
public class SleepPanda extends Panda {

	public SleepPanda(Game g, Tile tile) {
		super(g, tile);
	}

	/**
	 * Elszik-e éppen
	 */
	private boolean sleep;
	
	/**
	 * A panda elalszik
	 * Ha láncban van, elszakítja tõle kezdve a láncot
	 */
	@Override
	public boolean sleep() { //Csak a SleepPanda tud aludni
		
		if (prev != null)
			this.prev.Notify();
		return true;
	}
	
	public void setSleep(boolean b) {
		
		sleep = b;
	}
	
	public boolean getSleep() {
		
		return sleep;
	}
	
	/**
	 *  Ha nem alszik, sima pandaként mozog
	 */
	public void step() {

		if (!sleep) {
			super.step();
		}
	}
}
