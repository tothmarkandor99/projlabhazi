package projlabhazi;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class DrawableOrangutan extends DrawableObject {
	private DrawableTile nextTile;
	
	public DrawableOrangutan(int id, DrawableTile nextTile) {
		super(id);
		this.nextTile = nextTile;
	}

	@Override
	public void Draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(Color.ORANGE);
		g2.fillOval(tile.getX() - radius, tile.getY() - radius, radius * 2, radius * 2);
		g2.setColor(Color.BLACK);
		g2.drawString( ((Integer)id).toString(), tile.getX(), tile.getY());
		if (nextTile != null) {
			//TODO: step dir arrow
		}
	}

}
