package projlabhazi;

import java.util.ArrayList;

public class Timer {
	private ArrayList<Steppable> steppables;
	private ArrayList<Steppable> toRemove;
	
	public Timer() {
		ComInt.sendMessage("Timer.Timer");ComInt.indent++;
		steppables = new ArrayList<Steppable>();
		toRemove = new ArrayList<Steppable>();
	}
	
	public void tick() {
		ComInt.sendMessage("Timer.tick");ComInt.indent++;
		for (Steppable steppable : steppables) {
			steppable.step();
		}
		for (Steppable steppable : toRemove) { //Tick eseményre van olyan objektum, aki leiratkozhat a Timer-rõl, ezért hogy ne változzon a steppables kollekció a tick során, a leiratkozókat csak feljegyezzük, majd minden tick végén egyszerre eltávolítjuk
			steppables.remove(steppable);ComInt.indent++;
		}
		toRemove.clear();
	}
	
	public void addSteppable(Steppable s) {
		ComInt.sendMessage("Timer.addSteppable");ComInt.indent++;
		if (s != null)
			steppables.add(s);
	}
	
	public void removeSteppable(Steppable s) {
		ComInt.sendMessage("Timer.removeSteppable");ComInt.indent++;
		toRemove.add(s);
	}
	
	public void stop() {
		ComInt.sendMessage("Timer.stop");ComInt.indent++;
		//TODO: implementálni
	}
	
	public void start() {
		ComInt.sendMessage("Timer.start");ComInt.indent++;
		//TODO: implementálni
	}
	
	public void listAll() { //teszteléshez TODO: kivenni
		ComInt.sendMessage("Timer.listAll");ComInt.indent++;
		for (Steppable steppable : steppables) {
			System.out.println(steppable.getClass());
		}
	}
}
