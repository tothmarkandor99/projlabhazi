package projlabhazi;

import java.awt.Color;
import java.awt.Graphics2D;

public class DrawableChocolatePanda extends DrawablePanda {

	public DrawableChocolatePanda(int id) {
		super(id);
	}

	@Override
	public void Draw(Graphics2D g2) {
		g2.setColor(Color.BLACK);
		g2.fillOval(tile.getX() - radius, tile.getY() - radius, radius * 2, radius * 2);
	}

}
