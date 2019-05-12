package projlabhazi;

public class GamePanda extends Panda {
	public GamePanda(Game g) {
		super(g);
		
	}

	public void scare() { //Csak GamePanda tud megijedni
		
		prev.Notify();
	}
	
}
