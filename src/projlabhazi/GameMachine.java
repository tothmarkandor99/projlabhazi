package projlabhazi;

import java.util.Random;

/**
 * @author Corvinusplusplus
 * Játékgép, ami megijeszti a mellette álló ijedõs pandákat
 */
public class GameMachine extends Object {

	public GameMachine(Tile tile) {
		this.tile = tile;
	}
	
	/**
	 * Minden szomszédjával megpróbál interaktálni 
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
	 * Véletlen idõközönként ijeszt
	 */
	public void step() {
		if (new Random().nextBoolean())
			ring();
	}
}
