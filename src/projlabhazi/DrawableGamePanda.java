package projlabhazi;

import java.awt.Color;
import java.awt.Graphics2D;

public class DrawableGamePanda extends DrawablePanda {

	public DrawableGamePanda(int id) {
		super(id);
	}

	@Override
	public void Draw(Graphics2D g2) {
		g2.setColor(Color.BLUE);
		g2.fillOval(tile.getX() - radius, tile.getY() - radius, radius * 2, radius * 2);
	}

}
