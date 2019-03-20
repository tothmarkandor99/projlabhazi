package projlabhazi;

public class SleepPanda extends Panda {
	private boolean sleep;
	
	@Override
	public void sleep() {
		this.prev.Notify();
	}
	
	public void setSleep(boolean b) {
		sleep = b;
	}
	
	public boolean getSleep() {
		return sleep;
	}
	
	public void step() {
		if (!sleep) {
			super.step();
		}
	}
}
