package projlabhazi;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import javafx.scene.shape.MoveTo;

public class Wardrobe extends Object{
	private static ArrayList<Wardrobe> wardrobes = new ArrayList<Wardrobe>(); // Minden gardr�b �ssze van k�tve
	private Wardrobe nextWardrobe;
	
	public Wardrobe() {
		ComInt.sendMessage("Wardrobe.Wardrobe");ComInt.indent++;
		wardrobes.add(this);
	}
	
	public boolean receive(Orangutan o) { // Tud-e a gardr�b or�ngut�nt fogadni
		ComInt.sendMessage("Wardrobe.receive");ComInt.indent++;
		nextWardrobe = wardrobes.get(ThreadLocalRandom.current().nextInt(0, wardrobes.size())); //V�letlenszer�en v�lasztjuk ki, hogy melyik gardr�bb�l l�p majd ki az or�ngut�n
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
		ComInt.sendMessage("Wardrobe.receive");ComInt.indent++;
		return false;
	}

}
