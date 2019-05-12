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
		for (Steppable steppable : toRemove) { //Tick esem�nyre van olyan objektum, aki leiratkozhat a Timer-r�l, ez�rt hogy ne v�ltozzon a steppables kollekci� a tick sor�n, a leiratkoz�kat csak feljegyezz�k, majd minden tick v�g�n egyszerre elt�vol�tjuk
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
		
		//TODO: implement�lni
	}
	
	public void start() {
		
		//TODO: implement�lni
	}
	
}
