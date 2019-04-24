package projlabhazi;

public class SleepPanda extends Panda {
	public SleepPanda(Game g) {
		super(g);
		ComInt.print("SleepPanda.SleepPanda");ComInt.indent++;
	}

	private boolean sleep;
	
	@Override
	public boolean sleep() { //Csak a SleepPanda tud aludni
		ComInt.print("SleepPanda.sleep");ComInt.indent++;
		if (prev != null) // Ha l�ncban van, elszak�tja t�le kezdve a l�ncot
			this.prev.Notify();
		return true;
	}
	
	public void setSleep(boolean b) {
		ComInt.print("SleepPanda.setSleep");ComInt.indent++;
		sleep = b;
	}
	
	public boolean getSleep() {
		ComInt.print("SleepPanda.getSleep");ComInt.indent++;
		return sleep;
	}
	
	public void step() { // Ha nem alszik, sima pandak�nt mozog
		ComInt.print("SleepPanda.step");ComInt.indent++;
		if (!sleep) {
			super.step();
		}
	}
}
