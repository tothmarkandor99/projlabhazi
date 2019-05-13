package projlabhazi;

import java.util.ArrayList;
import java.util.Random;

public class Wardrobe extends Object{
	private static ArrayList<Wardrobe> wardrobes = new ArrayList<Wardrobe>(); // Minden gardr�b �ssze van k�tve
	private Wardrobe nextWardrobe;
	
	public Wardrobe(Tile tile) {
		this.tile = tile;
		if (!wardrobes.contains(this))
			wardrobes.add(this);
	}

	public boolean receive(Orangutan o) { // Tud-e a gardr�b or�ngut�nt fogadni
		
		nextWardrobe = wardrobes.get(new Random().nextInt(wardrobes.size())); //V�letlenszer�en v�lasztjuk ki, hogy melyik gardr�bb�l l�p majd ki az or�ngut�n

		int i; //el�fordulhat, hogy olyan gardr�bot sorsolunk ki, amelyb�l nem lehet kil�pni. Ennek kik�sz�b�l�se bonyolultabb implement�ci�t ig�nyel
		for (i = 0; i < nextWardrobe.getTile().getSides(); i++) {
			if (nextWardrobe.getTile().getNeighbour(i).receive(o)) {
				o.moveTo(nextWardrobe.getTile().getNeighbour(i)); //Ha van olyan szomsz�d mez� ahova lehet l�pni, az or�ngut�nt ide l�ptetj�k
				break;
			}
		}
		return false;
	}
	
	public boolean receive(Panda p) { //Panda nem l�phet �n�ll�an gardr�bra
		
		return false;
	}
	

}
