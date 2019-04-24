package projlabhazi;

public class GamePanda extends Panda {
	public GamePanda(Game g) {
		super(g);
		ComInt.print("GamePanda.GamePanda");ComInt.indent++;
	}

	public void scare() { //Csak GamePanda tud megijedni
		ComInt.print("GamePanda.scare");ComInt.indent++;
		prev.Notify();
	}
	
}
