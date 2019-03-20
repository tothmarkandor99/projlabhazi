package projlabhazi;

import java.util.concurrent.ThreadLocalRandom;

public class Wardrobe extends Object{
	private Wardrobe[] wardrobes;
	private Wardrobe nextWardrobe;
	private Tile nextNeighbour;
	
	public boolean receive(Orangutan o) {
		nextWardrobe = wardrobes[ThreadLocalRandom.current().nextInt(0, wardrobes.length)];
		int i;
		for (i = 0; i < nextWardrobe.getTile().getSides(); i++) {
			if (nextWardrobe.getTile().getNeighbour(i).receive(o) == true) {
				nextNeighbour = nextWardrobe.getTile().getNeighbour(i);
				break;
			}
		}
		return i == nextWardrobe.getTile().getSides();
	}
	
	public boolean receive(Panda p) {
		return nextNeighbour.receive(p);
	}
}
