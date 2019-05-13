package projlabhazi;

/**
 * @author Mark
 * Csokiautomat�t�l f�l� panda
 * Az automata csilingel�s�t�l ugrik egyet
 */
public class ChocolatePanda extends Panda {

	public ChocolatePanda(Game g, Tile tile) {
		super(g, tile);
		
	}

	/**
	 * Ugr�sra az alatta l�v� csempe kopik
	 */
	public void jump() {
		
		tile.crack();
	}
	
}
