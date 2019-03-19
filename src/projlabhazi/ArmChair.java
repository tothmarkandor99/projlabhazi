package projlabhazi;

public class ArmChair extends Object implements Interact {
	private Panda p;
	private int sleepTime;
	
	@Override
	public void interact(Object o) {
		
	}

	@Override
	public void interact(Panda p) {
		
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
		
	}

}
