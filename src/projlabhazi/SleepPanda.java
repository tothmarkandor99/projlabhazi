package projlabhazi;

public class SleepPanda extends Panda {
	public SleepPanda(Game g) {
		super(g);
		
	}

	private boolean sleep;
	
	@Override
	public boolean sleep() { //Csak a SleepPanda tud aludni
		
		if (prev != null) // Ha l�ncban van, elszak�tja t�le kezdve a l�ncot
			this.prev.Notify();
		return true;
	}
	
	public void setSleep(boolean b) {
		
		sleep = b;
	}
	
	public boolean getSleep() {
		
		return sleep;
	}
	
	public void step() { // Ha nem alszik, sima pandak�nt mozog
		
		if (!sleep) {
			super.step();
		}
	}
}
