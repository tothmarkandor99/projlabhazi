package projlabhazi;

public class ChocolatePanda extends Panda {
	public ChocolatePanda(Game g, Tile tile) {
		super(g, tile);
		
	}

	public void jump() { //Csak � tud ugrani
		
		tile.crack();
	}
	
}
