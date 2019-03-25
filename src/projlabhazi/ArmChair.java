package projlabhazi;

public class ArmChair extends Object implements Interact {
	private SleepPanda p;
	private int sleepTime;
	
	public ArmChair() {
		
	}
	
	@Override
	public void interact(Object o) { 
		if (this.p != null)
			return;
		if (o.sleep()) {
			setPanda((SleepPanda)o);
			p.getTile().setObject(null);
			p.setTile(null);
			setSleepTime(2); //TODO: véletlenszám
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
	
	public void step() {
		sleepTime--;
		if (p == null) {		
			for (int i = 0; i < getTile().getSides(); i++) {
				if (p == null && getTile().getNeighbour(i).getObject() != null) {
					interact(getTile().getNeighbour(i).getObject());
				}
			}
		} else if (sleepTime <= 0) {
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
