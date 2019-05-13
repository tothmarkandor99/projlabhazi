package projlabhazi;

/**
 * @author Corvinusplusplus
 * Ijedõs panda
 */
public class GamePanda extends Panda {

	public GamePanda(Game g, Tile tile) {
		super(g, tile);
		
	}

	/**
	 * Csak GamePanda tud megijedni
	 */
	public void scare() {
		if (prev != null)
			prev.Notify();
	}
	
}
