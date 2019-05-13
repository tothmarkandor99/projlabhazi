package projlabhazi;

import java.util.Random;

/**
 * @author Mark
 * Csokiautomata, célja sípolással megijeszteni a szomszédos mezõkön álló erre fogékony pandákat
 */
public class ChocolateMachine extends Object implements Interact {

	public ChocolateMachine(Tile tile) {
		this.tile = tile;
	}

	/**
	 * Minden szomszédjával megpróbál interaktálni
	 */
	public void beep() {
		
		for (int i = 0; i < tile.getSides(); i++) {
			if (tile.getNeighbour(i).getObject() != null) {
				this.interact(tile.getNeighbour(i).getObject());
			}
		}
	}
	
	/**
	 * Véletlen idõközönként sípol
	 */
	public void step() {
		if (new Random().nextBoolean())
			beep();
	}


	/**
	 * Ugrásra kényszeríti o-t
	 */
	public void interact(Object o) {		
		o.jump();
	}

}
