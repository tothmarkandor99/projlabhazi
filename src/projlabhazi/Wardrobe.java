package projlabhazi;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author Mark
 * Szekrény objektum. Ezen keresztül tudnak a karakterek teleportálni
 * Önszántából csak orángután léphet rá, de ráhúzhat pandákat is
 * Véletlenszerûen választott másik szekrényhez teleportál
 */
public class Wardrobe extends Object{
	/**
	 * Minden szekrény tud minden másik szekrényrõl
	 */
	private static ArrayList<Wardrobe> wardrobes = new ArrayList<Wardrobe>(); // Minden gardrób össze van kötve
	
	public Wardrobe(Tile tile) {
		this.tile = tile;
		if (!wardrobes.contains(this))
			wardrobes.add(this);
	}

	/**
	 * Tud-e a gardrób orángutánt fogadni
	 * Véletlenszerûen választjuk ki, hogy melyik gardróbból lép majd ki az orángután
	 * Ha van olyan szomszéd mezõ ahova lehet lépni, az orángutánt ide léptetjük
	 */
	public boolean receive(Orangutan o) {
		
		Wardrobe nextWardrobe = wardrobes.get(new Random().nextInt(wardrobes.size())); //Véletlenszerûen választjuk ki, hogy melyik gardróbból lép majd ki az orángután

		int i; //elõfordulhat, hogy olyan gardróbot sorsolunk ki, amelybõl nem lehet kilépni. Ennek kiküszöbölése bonyolultabb implementációt igényel
		for (i = 0; i < nextWardrobe.getTile().getSides(); i++) {
			if (nextWardrobe.getTile().getNeighbour(i).receive(o)) {
				o.moveTo(nextWardrobe.getTile().getNeighbour(i)); //Ha van olyan szomszéd mezõ ahova lehet lépni, az orángutánt ide léptetjük
				break;
			}
		}
		return false;
	}
	
	/**
	 * Panda nem léphet önállóan gardróbra
	 */
	public boolean receive(Panda p) {
		
		return false;
	}
	

}
