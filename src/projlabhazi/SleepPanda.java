package projlabhazi;

public class SleepPanda extends Panda {
	public SleepPanda(Game g) {
		super(g);
		ComInt.println("SleepPanda.SleepPanda");ComInt.indent++;
	}

	private boolean sleep;
	
	@Override
	public boolean sleep() { //Csak a SleepPanda tud aludni
		ComInt.println("SleepPanda.sleep");ComInt.indent++;
		if (prev != null) // Ha láncban van, elszakítja tõle kezdve a láncot
			this.prev.Notify();
		return true;
	}
	
	public void setSleep(boolean b) {
		ComInt.println("SleepPanda.setSleep");ComInt.indent++;
		sleep = b;
	}
	
	public boolean getSleep() {
		ComInt.println("SleepPanda.getSleep");ComInt.indent++;
		return sleep;
	}
	
	public void step() { // Ha nem alszik, sima pandaként mozog
		ComInt.println("SleepPanda.step");ComInt.indent++;
		if (!sleep) {
			super.step();
		}
	}
}
