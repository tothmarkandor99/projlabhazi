package projlabhazi;

import java.util.Random;

public class ArmChair extends Object implements Interact {
	private SleepPanda p;
	private int sleepTime;
	
	public ArmChair() {	}
	
	@Override
	public void interact(Object o) { // Megpróbálja elaltatni az o objektumot
		ComInt.println("ArmChair.interact");ComInt.indent++;
		if (this.p != null) // Ha már foglalt, más nem alhat benn
			return;
		if (o.sleep()) { // Ha tud aludni az objektum, csak SleepPanda lehet
			setPanda((SleepPanda)o);
			p.getTile().setObject(null); // Áthelyezzük a SleepPandát az ArmChair-be
			p.setTile(null);
			if (randomState == 2) {
				setSleepTime(new Random().nextInt(10));
			} else {
				setSleepTime(10);
			}
		}
	}

	public void setPanda(SleepPanda p) {
		ComInt.println("ArmChair.setPanda");ComInt.indent++;
		this.p = p;
	}
	
	public void setSleepTime(int i) {
		ComInt.println("ArmChair.setSleepTime");ComInt.indent++;
		sleepTime = i;
	}
	
	public int getSleepTime() {
		ComInt.println("ArmChair.getSleepTime");ComInt.indent++;
		return sleepTime;
	}
	
	public void step() { //Megpróbál minden szomszédos mezõrõl becsábítani bárkit, lehetõleg SleepPandát
		ComInt.println("ArmChair.step");ComInt.indent++;
		sleepTime--;
		if (p == null) {		
			for (int i = 0; i < getTile().getSides(); i++) {
				if (p == null && getTile().getNeighbour(i).getObject() != null) {
					interact(getTile().getNeighbour(i).getObject());
				}
			}
		} else if (sleepTime <= 0) { //Ha már valaki alszik és lejárt az idõ, megpróbálja kirakni egy üres szomszédos mezõre
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
