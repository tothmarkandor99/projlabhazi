package projlabhazi;

public class ChocolatePanda extends Panda {
	public ChocolatePanda(Game g) {
		super(g);
		
	}

	public void jump() { //Csak � tud ugrani
		
		tile.crack();
	}
	
}
