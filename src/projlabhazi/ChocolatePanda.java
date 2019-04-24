package projlabhazi;

public class ChocolatePanda extends Panda {
	public ChocolatePanda(Game g) {
		super(g);
		ComInt.print("ChocolatePanda.ChocolatePanda");ComInt.indent++;
	}

	public void jump() { //Csak õ tud ugrani
		ComInt.print("ChocolatePanda.jump");ComInt.indent++;
		tile.crack();
	}
	
}
