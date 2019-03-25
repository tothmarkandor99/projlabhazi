package projlabhazi;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import javafx.scene.shape.MoveTo;

public class Wardrobe extends Object{
	private static ArrayList<Wardrobe> wardrobes = new ArrayList<Wardrobe>(); // Minden gardrób össze van kötve
	private Wardrobe nextWardrobe;
	
	public Wardrobe() {
		wardrobes.add(this);
	}
	
	public boolean receive(Orangutan o) { // Tud-e a gardrób orángutánt fogadni
		nextWardrobe = wardrobes.get(ThreadLocalRandom.current().nextInt(0, wardrobes.size())); //Véletlenszerûen választjuk ki, hogy melyik gardróbból lép majd ki az orángután
		int i; //elõfordulhat, hogy olyan gardróbot sorsolunk ki, amelybõl nem lehet kilépni. Ennek kiküszöbölése bonyolultabb implementációt igényel
		for (i = 0; i < nextWardrobe.getTile().getSides(); i++) {
			if (nextWardrobe.getTile().getNeighbour(i).receive(o)) {
				o.moveTo(nextWardrobe.getTile().getNeighbour(i)); //Ha van olyan szomszéd mezõ ahova lehet lépni, az orángutánt ide léptetjük
				break;
			}
		}
		return false;
	}
	
	public boolean receive(Panda p) { //Panda nem léphet önállóan gardróbra
		return false;
	}

}
