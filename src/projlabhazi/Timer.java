package projlabhazi;

import java.util.ArrayList;

public class Timer {
	private ArrayList<Steppable> steppables;
	private ArrayList<Steppable> toRemove;
	
	public Timer() {
		steppables = new ArrayList<Steppable>();
		toRemove = new ArrayList<Steppable>();
	}
	
	public void tick() {
		for (Steppable steppable : toRemove) {
			steppables.remove(steppable);
		}
		toRemove.clear();
		for (Steppable steppable : steppables) {
			steppable.step();
		}
	}
	
	public void addSteppable(Steppable s) {
		if (s != null)
			steppables.add(s);
	}
	
	public void removeSteppable(Steppable s) {
		toRemove.add(s);
	}
	
	public void stop() {
		//TODO: implementálni
	}
	
	public void start() {
		//TODO: implementálni
	}
	
	public void listAll() {
		for (Steppable steppable : steppables) {
			System.out.println(steppable.getClass());
		}
	}
}
