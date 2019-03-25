package projlabhazi;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Panda extends Character {
	protected Character prev;
	protected Panda next;
	
	public Panda(Game g) {
		super(g);
		ComInt.sendMessage("Panda.Panda");ComInt.indent++;
		prev = null;
	}
	
	public boolean receive(Orangutan o) {
		ComInt.sendMessage("Panda.receive");ComInt.indent++;
		if (prev == null) {
			o.add(this);
		}
		return false;
	}
	
	public void setPrev(Character c) {
		ComInt.sendMessage("Panda.setPrev");ComInt.indent++;
		prev = c;
	}
	
	public Character getPrev() {
		ComInt.sendMessage("Panda.getPrev");ComInt.indent++;
		return prev;
	}
	
	public void step() {
		ComInt.sendMessage("Panda.step");ComInt.indent++;
		if (prev == null) {
			//TODO: teszteléshez kivéve, a pandák ne mozogjanak maguktól
			/*int nextDirection = ThreadLocalRandom.current().nextInt(0, tile.getSides());
			if (tile.put(this, nextDirection)) {
				moveTo(getTile().getNeighbour(nextDirection));
			}*/
		}
	}
	
	@Override
	public void Notify() { //Elengedi a mögötte álló pandák kezét és az elõtte álló karakter kezés
		ComInt.sendMessage("Panda.Notify");ComInt.indent++;
		next.release();
		this.setNext(null);
	}
	
	public void release() { //Rekurzívan elengedi az egymás mögött álló pandák kezét
		ComInt.sendMessage("Panda.release");ComInt.indent++;
		if (next != null) {
			next.release();
		}
		setNext(null);
		setPrev(null);
	}
	
	public void die() { // A panda a játék során meghal
		ComInt.sendMessage("Panda.die");ComInt.indent++;
		if (prev != null) { //A mögötte állók elengedik egymás kezét
			prev.Notify();
		}
		game.getTimer().removeSteppable(this);
		game.pandaDies();
		getTile().setObject(null);
	}
	
	public void kill() { // A pandát megszámolás során megöljük. Megölünk a láncban minden más pandát is
		ComInt.sendMessage("Panda.kill");ComInt.indent++;
		game.getTimer().removeSteppable(this);
		game.pandaDies();
		if (getPrev() != null)
			getPrev().setNext(null);
		if (getNext() != null)
			getNext().setPrev(null);
		getTile().setObject(null);
	}
}
