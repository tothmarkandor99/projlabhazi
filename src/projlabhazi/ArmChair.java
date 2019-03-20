package projlabhazi;

public class ArmChair extends Object implements Interact {
	private Panda p;
	private int sleepTime;
	
	@Override
	public void interact(Object o) { }

	@Override
	public void interact(Panda p) {
		if (this.p != null)
			return;
		p.sleep();
		setPanda(p);
		setSleepTime(10); //TODO: véletlenszám
	}
	
	public void setPanda(Panda p) {
		this.p = p;
	}
	
	public void setSleepTime(int i) {
		sleepTime = i;
	}
	
	public int getSleepTime() {
		return sleepTime;
	}
	
	public void step() {
		if (p == null) 
			return;
		
		for (int i = 0; i < getTile().getSides(); i++) {
			if (getTile().getNeighbour(i).getObject() != null) {
				interact(getTile().getNeighbour(i).getObject());
			}
		}
		sleepTime--;
	}

}
