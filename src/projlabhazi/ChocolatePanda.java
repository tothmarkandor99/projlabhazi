package projlabhazi;

public class ChocolatePanda extends Panda {
	public ChocolatePanda(Game g) {
		super(g);
		ComInt.println("ChocolatePanda.ChocolatePanda");ComInt.indent++;
	}

	public void jump() { //Csak õ tud ugrani
		ComInt.println("ChocolatePanda.jump");ComInt.indent++;
		tile.crack();
	}
	
}
