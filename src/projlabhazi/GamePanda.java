package projlabhazi;

public class GamePanda extends Panda {
	public GamePanda(Game g, Tile tile) {
		super(g, tile);
		
	}

	public void scare() { //Csak GamePanda tud megijedni
		
		prev.Notify();
	}
	
}
