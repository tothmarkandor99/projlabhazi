package projlabhazi;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class DrawableBreakingTile extends DrawableTile {

	public DrawableBreakingTile(int id, int x, int y) {
		super(id, x, y);
	}

	@Override
	public void Draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(Color.RED);
		g2.fillOval(getX() - radius, getY() - radius, radius * 2, radius * 2);
		g2.setColor(Color.BLACK);
		g2.drawString(((Integer)getId()).toString(), getX(), getY());
	}

}
