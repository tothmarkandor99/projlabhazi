package projlabhazi;

/**
 * @author Mark
 * Csokiautomatától félõ panda
 * Az automata csilingelésétõl ugrik egyet
 */
public class ChocolatePanda extends Panda {

	public ChocolatePanda(Game g, Tile tile) {
		super(g, tile);
		
	}

	/**
	 * Ugrásra az alatta lévõ csempe kopik
	 */
	public void jump() {
		
		tile.crack();
	}
	
}
