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
		for (Steppable steppable : toRemove) { //Tick esem�nyre van olyan objektum, aki leiratkozhat a Timer-r�l, ez�rt hogy ne v�ltozzon a steppables kollekci� a tick sor�n, a leiratkoz�kat csak feljegyezz�k, majd minden tick v�g�n egyszerre elt�vol�tjuk
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
		//TODO: implement�lni
	}
	
	public void start() {
		ComInt.sendMessage("Timer.start");ComInt.indent++;
		//TODO: implement�lni
	}
	
	public void listAll() { //tesztel�shez TODO: kivenni
		ComInt.sendMessage("Timer.listAll");ComInt.indent++;
		for (Steppable steppable : steppables) {
			System.out.println(steppable.getClass());
		}
	}
}
