package projlabhazi;

import java.util.Random;

/**
 * @author Corvinusplusplus
 * Karosszék osztály. Célja a mellette levõ pandát alvásra csábítani
 */
public class ArmChair extends Object implements Interact {
	/**
	 * Karosszékben alvó panda
	 */
	private SleepPanda p;
	/**
	 * Ennyi ideje van még hátra az alvásból a pandának
	 */
	private int sleepTime;
	
	public ArmChair(Tile tile) {	
		this.tile = tile;
	}
	
	/**
	 * Megpróbálja elaltatni az o objektumot
	 * Ha már foglalt, más nem alhat benn
	 * Ha tud aludni az objektum, csak SleepPanda lehet, áthelyezzük a SleepPandát az ArmChair-be
	 */
	@Override
	public void interact(Object o) {
		if (this.p != null)
			return;
		if (o.sleep()) {
			setPanda((SleepPanda)o);
			p.getTile().setObject(null);
			p.setTile(tile);
			setSleepTime(new Random().nextInt(10));

		}
	}

	public void setPanda(SleepPanda p) {
		this.p = p;
	}
	
	public void setSleepTime(int i) {
		sleepTime = i;
	}
	
	public int getSleepTime() {
		
		return sleepTime;
	}
	
	/**
	 * Megpróbál minden szomszédos mezõrõl becsábítani bárkit, lehetõleg SleepPandát
	 * Ha már valaki alszik és lejárt az idõ, megpróbálja kirakni egy üres szomszédos mezõre
	 */
	public void step() {
		if (sleepTime > 0)
			sleepTime--;
		if (p == null) {		
			for (int i = 0; i < getTile().getSides(); i++) {
				if (p == null && getTile().getNeighbour(i).getObject() != null) {
					interact(getTile().getNeighbour(i).getObject());
				}
			}
		} else if (sleepTime == 0) {
			int i;
			for (i = 0; i < this.getTile().getSides(); i++) {
				if (this.getTile().getNeighbour(i).receive(p)) {
					p.moveTo(this.getTile().getNeighbour(i));
					break;
				}
			}
		}
	}

}
