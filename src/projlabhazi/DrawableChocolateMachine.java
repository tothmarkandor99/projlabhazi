package projlabhazi;

import java.awt.Color;
import java.awt.Graphics2D;

public class DrawableChocolateMachine extends DrawableObject {
	public static int radius = 20;
	
	public DrawableChocolateMachine(int id) {
		super(id);
	}

	@Override
	public void Draw(Graphics2D g2) {
		g2.setColor(new Color(197, 224, 181));
		g2.fillOval(tile.getX() - radius, tile.getY() - radius, radius * 2, radius * 2);
	}

}
