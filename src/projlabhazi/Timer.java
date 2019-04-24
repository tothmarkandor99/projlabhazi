package projlabhazi;

import java.util.ArrayList;

public class Timer {
	private ArrayList<Steppable> steppables;
	private ArrayList<Steppable> toRemove;
	java.util.Timer timer;
	
	public Timer() {
		ComInt.print("Timer.Timer");ComInt.indent++;
		steppables = new ArrayList<Steppable>();
		toRemove = new ArrayList<Steppable>();
	}
	
	public void tick() {
		ComInt.print("Timer.tick");ComInt.indent++;
		for (Steppable steppable : steppables) {
			steppable.step();
		}
		for (Steppable steppable : toRemove) { //Tick eseményre van olyan objektum, aki leiratkozhat a Timer-rõl, ezért hogy ne változzon a steppables kollekció a tick során, a leiratkozókat csak feljegyezzük, majd minden tick végén egyszerre eltávolítjuk
			steppables.remove(steppable);ComInt.indent++;
		}
		toRemove.clear();
	}
	
	public void addSteppable(Steppable s) {
		ComInt.print("Timer.addSteppable");ComInt.indent++;
		if (s != null)
			steppables.add(s);
	}
	
	public void removeSteppable(Steppable s) {
		ComInt.print("Timer.removeSteppable");ComInt.indent++;
		toRemove.add(s);
	}
	
	public void stop() {
		ComInt.print("Timer.stop");ComInt.indent++;
		//TODO: implementálni
	}
	
	public void start() {
		ComInt.print("Timer.start");ComInt.indent++;
		//TODO: implementálni
	}
	
	public void listAll() { //teszteléshez TODO: kivenni
		ComInt.print("Timer.listAll");ComInt.indent++;
		for (Steppable steppable : steppables) {
			ComInt.println(steppable.getClass().toString());
		}
	}
}
