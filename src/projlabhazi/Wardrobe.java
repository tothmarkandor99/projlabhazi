package projlabhazi;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import javafx.scene.shape.MoveTo;

public class Wardrobe extends Object{
	private static ArrayList<Wardrobe> wardrobes = new ArrayList<Wardrobe>();
	private Wardrobe nextWardrobe;
	
	public Wardrobe() {
		wardrobes.add(this);
	}
	
	public boolean receive(Orangutan o) {
		nextWardrobe = wardrobes.get(ThreadLocalRandom.current().nextInt(0, wardrobes.size()));
		int i;
		for (i = 0; i < nextWardrobe.getTile().getSides(); i++) {
			if (nextWardrobe.getTile().getNeighbour(i).receive(o)) {
				o.moveTo(nextWardrobe.getTile().getNeighbour(i));
				break;
			}
		}
		return false;
	}
	
	public boolean receive(Panda p) {
		return false;
	}

}
