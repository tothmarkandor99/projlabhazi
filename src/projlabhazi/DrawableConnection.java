package projlabhazi;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

/**
 * @author Corvinusplusplus
 * K�t DrawableTile k�z�ppontj�t �sszek�t� vonal
 */
public class DrawableConnection implements Drawable {
	DrawableTile from, to;
	
	public DrawableConnection(DrawableTile from, DrawableTile to) {
		this.from = from;
		this.to = to;
	}

	@Override
	public void Draw(Graphics2D g2) {
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(Color.BLACK);
		g2.drawLine(from.getX(), from.getY(), to.getX(), to.getY());
		/*
		// Ezt a r�szt kikommentezve lehet nyilat rajzoltatni a vonal to fel�li v�g�hez
		double dist = Math.sqrt((to.getX() - from.getX()) * (to.getX() - from.getX()) + (to.getY() - from.getY()) * (to.getY() - from.getY()));
		double nx = (to.getX() - from.getX()) / dist;
		double ny = (to.getY() - from.getY()) / dist;
		double angle = Math.PI / 6;
		double dx = nx * 10 * Math.cos(angle) - ny * 10 * Math.sin(angle);
		double dy = nx * 10 * Math.sin(angle) + ny * 10 * Math.cos(angle);
		g2.drawLine((int)(to.getX() - nx * DrawableTile.radius), (int)(to.getY() - ny * DrawableTile.radius), (int)(to.getX() - nx * DrawableTile.radius - dx), (int)(to.getY() - ny * DrawableTile.radius - dy));
		angle = -Math.PI / 6;
		dx = nx * 10 * Math.cos(angle) - ny * 10 * Math.sin(angle);
		dy = nx * 10 * Math.sin(angle) + ny * 10 * Math.cos(angle);
		g2.drawLine((int)(to.getX() - nx * DrawableTile.radius), (int)(to.getY() - ny * DrawableTile.radius), (int)(to.getX() - nx * DrawableTile.radius - dx), (int)(to.getY() - ny * DrawableTile.radius - dy));
		 */
	}

}
