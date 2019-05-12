package projlabhazi;

import java.awt.Color;
import java.awt.Graphics2D;

public class DrawableExit extends DrawableObject {
	public static int radius = 20;
	public DrawableExit(int id) {
		super(id);
	}

	@Override
	public void Draw(Graphics2D g2) {
		g2.setColor(Color.YELLOW);
		g2.fillOval(tile.getX() - radius, tile.getY() - radius, radius * 2, radius * 2);
		//g2.setColor(Color.BLACK);
		//g2.drawString( ((Integer)id).toString(), tile.getX(), tile.getY());
	}

}
