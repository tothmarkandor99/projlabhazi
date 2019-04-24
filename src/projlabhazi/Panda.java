package projlabhazi;

import java.util.Random;

public abstract class Panda extends Character {
	protected Character prev;
	protected Panda next;
	
	public Panda(Game g) {
		super(g);
		ComInt.println("Panda.Panda");ComInt.indent++;
		prev = null;
	}
	
	public boolean receive(Orangutan o) {
		ComInt.println("Panda.receive");ComInt.indent++;
		o.add(this);
		return false;
	}
	
	public void setPrev(Character c) {
		ComInt.println("Panda.setPrev");ComInt.indent++;
		prev = c;
	}
	
	public Character getPrev() {
		ComInt.println("Panda.getPrev");ComInt.indent++;
		return prev;
	}
	
	public void step() {
		ComInt.println("Panda.step");ComInt.indent++;
		if (prev == null) {
			//TODO: tesztel�shez kiv�ve, a pand�k ne mozogjanak magukt�l
			if (randomState == 2) {
				int nextDirection = new Random().nextInt(tile.getSides());
				if (tile.put(this, nextDirection)) {
					moveTo(getTile().getNeighbour(nextDirection));
				}				
			}
		}
	}
	
	@Override
	public void Notify() { //Elengedi a m�g�tte �ll� pand�k kez�t �s az el�tte �ll� karakter kez�s
		ComInt.println("Panda.Notify");ComInt.indent++;
		next.release();
		this.setNext(null);
	}
	
	public void release() { //Rekurz�van elengedi az egym�s m�g�tt �ll� pand�k kez�t
		ComInt.println("Panda.release");ComInt.indent++;
		if (next != null) {
			next.release();
		}
		setNext(null);
		setPrev(null);
	}
	
	public void die() { // A panda a j�t�k sor�n meghal
		ComInt.println("Panda.die");ComInt.indent++;
		if (prev != null) { //A m�g�tte �ll�k elengedik egym�s kez�t
			prev.Notify();
		}
		game.getTimer().removeSteppable(this);
		game.pandaDies();
		getTile().setObject(null);
	}
	
	public void kill() { // A pand�t megsz�mol�s sor�n meg�lj�k. Meg�l�nk a l�ncban minden m�s pand�t is
		ComInt.println("Panda.kill");ComInt.indent++;
		game.getTimer().removeSteppable(this);
		game.pandaDies();
		if (getPrev() != null)
			getPrev().setNext(null);
		if (getNext() != null)
			getNext().setPrev(null);
		getTile().setObject(null);
	}
}
