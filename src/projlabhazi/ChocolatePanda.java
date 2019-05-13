package projlabhazi;

/**
 * @author Corvinusplusplus
 * Csokiautomatától félő panda
 * Az automata csilingelésétől ugrik egyet
 */
public class ChocolatePanda extends Panda {

	public ChocolatePanda(Game g, Tile tile) {
		super(g, tile);
		
	}

	/**
	 * Ugrásra az alatta lévő csempe kopik
	 */
	public void jump() {
		
		tile.crack();
	}
	
}
