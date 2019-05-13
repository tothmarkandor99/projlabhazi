package projlabhazi;

import java.util.Random;

/**
 * @author Mark
 * Csokiautomata, c�lja s�pol�ssal megijeszteni a szomsz�dos mez�k�n �ll� erre fog�kony pand�kat
 */
public class ChocolateMachine extends Object implements Interact {

	public ChocolateMachine(Tile tile) {
		this.tile = tile;
	}

	/**
	 * Minden szomsz�dj�val megpr�b�l interakt�lni
	 */
	public void beep() {
		
		for (int i = 0; i < tile.getSides(); i++) {
			if (tile.getNeighbour(i).getObject() != null) {
				this.interact(tile.getNeighbour(i).getObject());
			}
		}
	}
	
	/**
	 * V�letlen id�k�z�nk�nt s�pol
	 */
	public void step() {
		if (new Random().nextBoolean())
			beep();
	}


	/**
	 * Ugr�sra k�nyszer�ti o-t
	 */
	public void interact(Object o) {		
		o.jump();
	}

}
