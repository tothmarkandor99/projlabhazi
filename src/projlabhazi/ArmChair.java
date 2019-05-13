package projlabhazi;

import java.util.Random;

/**
 * @author Corvinusplusplus
 * Karossz�k oszt�ly. C�lja a mellette lev� pand�t alv�sra cs�b�tani
 */
public class ArmChair extends Object implements Interact {
	/**
	 * Karossz�kben alv� panda
	 */
	private SleepPanda p;
	/**
	 * Ennyi ideje van m�g h�tra az alv�sb�l a pand�nak
	 */
	private int sleepTime;
	
	public ArmChair(Tile tile) {	
		this.tile = tile;
	}
	
	/**
	 * Megpr�b�lja elaltatni az o objektumot
	 * Ha m�r foglalt, m�s nem alhat benn
	 * Ha tud aludni az objektum, csak SleepPanda lehet, �thelyezz�k a SleepPand�t az ArmChair-be
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
	 * Megpr�b�l minden szomsz�dos mez�r�l becs�b�tani b�rkit, lehet�leg SleepPand�t
	 * Ha m�r valaki alszik �s lej�rt az id�, megpr�b�lja kirakni egy �res szomsz�dos mez�re
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
