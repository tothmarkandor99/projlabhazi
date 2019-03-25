package projlabhazi;

public class ChocolatePanda extends Panda {
	public ChocolatePanda(Game g) {
		super(g);
		ComInt.sendMessage("ChocolatePanda.ChocolatePanda");ComInt.indent++;
	}

	public void jump() { //Csak õ tud ugrani
		ComInt.sendMessage("ChocolatePanda.jump");ComInt.indent++;
		tile.crack();
	}
	
}
