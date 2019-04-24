package projlabhazi;

import java.util.ArrayList;
import java.util.Random;

public class Wardrobe extends Object{
	private static ArrayList<Wardrobe> wardrobes = new ArrayList<Wardrobe>(); // Minden gardrób össze van kötve
	private Wardrobe nextWardrobe;
	
	public Wardrobe() {
		ComInt.print("Wardrobe.Wardrobe");ComInt.indent++;
		wardrobes.add(this);
	}
	
	public boolean receive(Orangutan o) { // Tud-e a gardrób orángutánt fogadni
		ComInt.print("Wardrobe.receive");ComInt.indent++;
		if (randomState == 2)
			nextWardrobe = wardrobes.get(new Random().nextInt(wardrobes.size())); //Véletlenszerûen választjuk ki, hogy melyik gardróbból lép majd ki az orángután
		else
			nextWardrobe = wardrobes.get(0) == this ? wardrobes.get(1) : wardrobes.get(0);
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
		ComInt.print("Wardrobe.receive");ComInt.indent++;
		return false;
	}

}
