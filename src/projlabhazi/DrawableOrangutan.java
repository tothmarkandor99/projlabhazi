package projlabhazi;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;

public class DrawableOrangutan extends DrawableObject {
	private DrawableTile nextTile;
	private boolean active;
	
	public DrawableOrangutan(int id, DrawableTile nextTile, boolean active) {
		super(id);
		this.nextTile = nextTile;
		this.active = active;
	}

	@Override
	public void Draw(Graphics2D g2) {
		g2.setColor(Color.ORANGE);
		g2.fillOval(tile.getX() - radius, tile.getY() - radius, radius * 2, radius * 2);
		//g2.setColor(Color.BLACK);
		//g2.drawString( ((Integer)id).toString(), tile.getX(), tile.getY());
		if (active && nextTile != null) {
			g2.setColor(Color.BLACK);
			g2.setStroke(new BasicStroke(3.0f));
			double dist = Math.sqrt((nextTile.getX() - tile.getX()) * (nextTile.getX() - tile.getX()) + (nextTile.getY() - tile.getY()) * (nextTile.getY() - tile.getY()));
			double nx = (nextTile.getX() - tile.getX()) / dist;
			double ny = (nextTile.getY() - tile.getY()) / dist;
			double angle = Math.PI / 6;
			double dx = nx * 10 * Math.cos(angle) - ny * 10 * Math.sin(angle);
			double dy = nx * 10 * Math.sin(angle) + ny * 10 * Math.cos(angle);
			g2.drawLine((int)(tile.getX() + nx * DrawableOrangutan.radius + nx * 9), (int)(tile.getY() + ny * DrawableOrangutan.radius + ny * 9), (int)(tile.getX() + nx * DrawableOrangutan.radius - dx + nx * 9), (int)(tile.getY() + ny * DrawableOrangutan.radius - dy + ny * 9));
			angle = -Math.PI / 6;
			dx = nx * 10 * Math.cos(angle) - ny * 10 * Math.sin(angle);
			dy = nx * 10 * Math.sin(angle) + ny * 10 * Math.cos(angle);
			g2.drawLine((int)(tile.getX() + nx * DrawableOrangutan.radius + nx * 9), (int)(tile.getY() + ny * DrawableOrangutan.radius + ny * 9), (int)(tile.getX() + nx * DrawableOrangutan.radius - dx + nx * 9), (int)(tile.getY() + ny * DrawableOrangutan.radius - dy + ny * 9));
			g2.setStroke(new BasicStroke(1.0f));
		}
	}

}
