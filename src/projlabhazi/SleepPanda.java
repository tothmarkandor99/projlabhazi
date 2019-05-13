package projlabhazi;

import java.util.Random;

/**
 * @author Corvinusplusplus
 * Alusz�kony panda
 * A karossz�k k�pes alv�sra cs�b�tani
 * Ekkor az alv�si id� lej�rt�ig nem mozdul a karossz�kb�l
 */
public class SleepPanda extends Panda {

	public SleepPanda(Game g, Tile tile) {
		super(g, tile);
	}

	/**
	 * Elszik-e �ppen
	 */
	private boolean sleep;
	
	/**
	 * A panda elalszik
	 * Ha l�ncban van, elszak�tja t�le kezdve a l�ncot
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
	 *  Ha nem alszik, sima pandak�nt mozog
	 */
	public void step() {

		if (!sleep) {
			super.step();
		}
	}
}
