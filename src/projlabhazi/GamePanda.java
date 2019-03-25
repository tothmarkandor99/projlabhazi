package projlabhazi;

public class GamePanda extends Panda {
	public GamePanda(Game g) {
		super(g);
		ComInt.sendMessage("GamePanda.GamePanda");ComInt.indent++;
	}

	public void scare() { //Csak GamePanda tud megijedni
		ComInt.sendMessage("GamePanda.scare");ComInt.indent++;
		prev.Notify();
	}
	
}
