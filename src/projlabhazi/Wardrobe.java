package projlabhazi;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author Mark
 * Szekr�ny objektum. Ezen kereszt�l tudnak a karakterek teleport�lni
 * �nsz�nt�b�l csak or�ngut�n l�phet r�, de r�h�zhat pand�kat is
 * V�letlenszer�en v�lasztott m�sik szekr�nyhez teleport�l
 */
public class Wardrobe extends Object{
	/**
	 * Minden szekr�ny tud minden m�sik szekr�nyr�l
	 */
	private static ArrayList<Wardrobe> wardrobes = new ArrayList<Wardrobe>(); // Minden gardr�b �ssze van k�tve
	
	public Wardrobe(Tile tile) {
		this.tile = tile;
		if (!wardrobes.contains(this))
			wardrobes.add(this);
	}

	/**
	 * Tud-e a gardr�b or�ngut�nt fogadni
	 * V�letlenszer�en v�lasztjuk ki, hogy melyik gardr�bb�l l�p majd ki az or�ngut�n
	 * Ha van olyan szomsz�d mez� ahova lehet l�pni, az or�ngut�nt ide l�ptetj�k
	 */
	public boolean receive(Orangutan o) {
		
		Wardrobe nextWardrobe = wardrobes.get(new Random().nextInt(wardrobes.size())); //V�letlenszer�en v�lasztjuk ki, hogy melyik gardr�bb�l l�p majd ki az or�ngut�n

		int i; //el�fordulhat, hogy olyan gardr�bot sorsolunk ki, amelyb�l nem lehet kil�pni. Ennek kik�sz�b�l�se bonyolultabb implement�ci�t ig�nyel
		for (i = 0; i < nextWardrobe.getTile().getSides(); i++) {
			if (nextWardrobe.getTile().getNeighbour(i).receive(o)) {
				o.moveTo(nextWardrobe.getTile().getNeighbour(i)); //Ha van olyan szomsz�d mez� ahova lehet l�pni, az or�ngut�nt ide l�ptetj�k
				break;
			}
		}
		return false;
	}
	
	/**
	 * Panda nem l�phet �n�ll�an gardr�bra
	 */
	public boolean receive(Panda p) {
		
		return false;
	}
	

}
