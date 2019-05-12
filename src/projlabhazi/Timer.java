package projlabhazi;

import java.util.ArrayList;

public class Timer {
	private ArrayList<Steppable> steppables;
	private ArrayList<Steppable> toRemove;
	java.util.Timer timer;
	
	public Timer() {
		
		steppables = new ArrayList<Steppable>();
		toRemove = new ArrayList<Steppable>();
	}
	
	public void tick() {
		
		for (Steppable steppable : steppables) {
			steppable.step();
		}
		for (Steppable steppable : toRemove) { //Tick eseményre van olyan objektum, aki leiratkozhat a Timer-rõl, ezért hogy ne változzon a steppables kollekció a tick során, a leiratkozókat csak feljegyezzük, majd minden tick végén egyszerre eltávolítjuk
			steppables.remove(steppable);
		}
		toRemove.clear();
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
	
}
