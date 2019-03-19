package projlabhazi;

import java.util.ArrayList;

public class Timer {
	private ArrayList<Steppable> steppables;
	
	public Timer() {
		steppables = new ArrayList<Steppable>();
	}
	
	public void tick() {
		for (Steppable steppable : steppables) {
			steppable.step();
		}
	}
	
	public void addSteppable(Steppable s) {
		steppables.add(s);
	}
	
	public void removeSteppable(Steppable s) {
		steppables.remove(s);
	}
}
