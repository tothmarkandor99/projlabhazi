package projlabhazi;

public class GamePanda extends Panda {
	public GamePanda(Game g) {
		super(g);
		ComInt.println("GamePanda.GamePanda");ComInt.indent++;
	}

	public void scare() { //Csak GamePanda tud megijedni
		ComInt.println("GamePanda.scare");ComInt.indent++;
		prev.Notify();
	}
	
}
