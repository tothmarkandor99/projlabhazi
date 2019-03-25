package projlabhazi;

public class SleepPanda extends Panda {
	public SleepPanda(Game g) {
		super(g);
	}

	private boolean sleep;
	
	@Override
	public boolean sleep() {
		if (prev != null)
			this.prev.Notify();
		return true;
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
