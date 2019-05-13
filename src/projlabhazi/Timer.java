package projlabhazi;

import java.util.ArrayList;
import java.util.TimerTask;

/**
 * @author Mark
 * Saj�t id�z�t� oszt�ly, ami 2 m�sodpercenk�nt �rtes�ti a feliratkozott objektumokat
 * K�l�n sz�mon tartja a megjelen�t� objektomot, ezt utolj�ra �rtes�ti
 */
public class Timer {
	/**
	 * Feliratkozott objektumok
	 */
	private ArrayList<Steppable> steppables;
	/**
	 * Leiratkozni k�v�n� objektumok
	 */
	private ArrayList<Steppable> toRemove;
	/**
	 * �rajel-gener�tor
	 */
	java.util.Timer timer;
	/**
	 * Dedik�lt objektum a megjelen�t�shez
	 */
	private Steppable GUI;

	public Timer() {
		steppables = new ArrayList<Steppable>();
		toRemove = new ArrayList<Steppable>();
	}
	
	/**
	 * �rtes�ti a sima feliratkozott objektumokat, majd a megjelen�t� objektumot
	 * Ezut�n t�rli a leiratkoz�st k�r� objektumokat
	 */
	public void tick() {
		for (Steppable steppable : steppables) {
			steppable.step();
		}
		GUI.step();
		for (Steppable steppable : toRemove) { //Tick esem�nyre van olyan objektum, aki leiratkozhat a Timer-r�l, ez�rt hogy ne v�ltozzon a steppables kollekci� a tick sor�n, a leiratkoz�kat csak feljegyezz�k, majd minden tick v�g�n egyszerre elt�vol�tjuk
			steppables.remove(steppable);
		}
		toRemove.clear();
	}
	
	/**
	 * @param s
	 * s-t feliratkoztatja
	 */
	public void addSteppable(Steppable s) {
		if (s != null || !steppables.contains(s))
			steppables.add(s);
	}
	
	/**
	 * @param s
	 * s-t leiratkoztatja
	 */
	public void removeSteppable(Steppable s) {
		
		toRemove.add(s);
	}
	
	/**
	 * Mindenkit leiratkoztat
	 */
	public void clearSteppables() {
		for (Steppable steppable : steppables) {
			toRemove.add(steppable);
		}
	}
	
	/**
	 * Meg�ll�tja az �rajelt
	 */
	public void stop() {
		timer.cancel();
	}
	
	/**
	 * Elind�tja az �rajelt
	 */
	public void start() {
		timer = new java.util.Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				tick();
			}
		}, 2 * 1000, 2 * 1000);
	}
	
	public void setGUI(Steppable gui) {
		GUI = gui;
	}
	
}
