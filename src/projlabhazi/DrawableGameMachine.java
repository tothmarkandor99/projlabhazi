package projlabhazi;

import java.awt.Color;
import java.awt.Graphics2D;

public class DrawableGameMachine extends DrawableObject {
	public static int radius = 20;
	
	public DrawableGameMachine(int id) {
		super(id);
	}

	@Override
	public void Draw(Graphics2D g2) {
		g2.setColor(new Color(222, 234, 246));
		g2.fillOval(tile.getX() - radius, tile.getY() - radius, radius * 2, radius * 2);
	}

}
