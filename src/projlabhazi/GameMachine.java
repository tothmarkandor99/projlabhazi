package projlabhazi;

import java.util.Random;

/**
 * @author Corvinusplusplus
 * J�t�kg�p, ami megijeszti a mellette �ll� ijed�s pand�kat
 */
public class GameMachine extends Object {

	public GameMachine(Tile tile) {
		this.tile = tile;
	}
	
	/**
	 * Minden szomsz�dj�val megpr�b�l interakt�lni 
	 */
	public void ring() {
		
		for (int i = 0; i < tile.getSides(); i++) {
			if (tile.getNeighbour(i).getObject() != null) {
				this.interact(tile.getNeighbour(i).getObject());
			}
		}
	}
	
	/**
	 * @param o
	 * Megijeszti o-t
	 */
	public void interact(Object o) {
		
		o.scare();
	}


	/**
	 * V�letlen id�k�z�nk�nt ijeszt
	 */
	public void step() {
		if (new Random().nextBoolean())
			ring();
	}
}
