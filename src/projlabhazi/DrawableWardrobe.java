package projlabhazi;

import java.awt.Color;
import java.awt.Graphics2D;

public class DrawableWardrobe extends DrawableObject {
	public static int radius = 20;
	
	public DrawableWardrobe(int id) {
		super(id);
	}

	@Override
	public void Draw(Graphics2D g2) {
		g2.setColor(new Color(251, 229, 215));
		g2.fillOval(tile.getX() - radius, tile.getY() - radius, radius * 2, radius * 2);
	}

}
