package projlabhazi;

import java.awt.Color;
import java.awt.Graphics2D;

public class DrawableSleepPanda extends DrawablePanda {

	public DrawableSleepPanda(int id) {
		super(id);
	}

	@Override
	public void Draw(Graphics2D g2) {
		g2.setColor(new Color(83, 130, 50));
		g2.fillOval(tile.getX() - radius, tile.getY() - radius, radius * 2, radius * 2);
	}

}
