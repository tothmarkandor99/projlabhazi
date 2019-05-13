package projlabhazi;

import java.util.ArrayList;
import java.util.TimerTask;

/**
 * @author Mark
 * Saját idõzítõ osztály, ami 2 másodpercenként értesíti a feliratkozott objektumokat
 * Külön számon tartja a megjelenítõ objektomot, ezt utoljára értesíti
 */
public class Timer {
	/**
	 * Feliratkozott objektumok
	 */
	private ArrayList<Steppable> steppables;
	/**
	 * Leiratkozni kívánó objektumok
	 */
	private ArrayList<Steppable> toRemove;
	/**
	 * Órajel-generátor
	 */
	java.util.Timer timer;
	/**
	 * Dedikált objektum a megjelenítéshez
	 */
	private Steppable GUI;

	public Timer() {
		steppables = new ArrayList<Steppable>();
		toRemove = new ArrayList<Steppable>();
	}
	
	/**
	 * Értesíti a sima feliratkozott objektumokat, majd a megjelenítõ objektumot
	 * Ezután törli a leiratkozást kérõ objektumokat
	 */
	public void tick() {
		for (Steppable steppable : steppables) {
			steppable.step();
		}
		GUI.step();
		for (Steppable steppable : toRemove) { //Tick eseményre van olyan objektum, aki leiratkozhat a Timer-rõl, ezért hogy ne változzon a steppables kollekció a tick során, a leiratkozókat csak feljegyezzük, majd minden tick végén egyszerre eltávolítjuk
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
	 * Megállítja az órajelt
	 */
	public void stop() {
		timer.cancel();
	}
	
	/**
	 * Elindítja az órajelt
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
