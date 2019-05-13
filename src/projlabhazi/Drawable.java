package projlabhazi;

import java.awt.Graphics2D;

/**
 * @author Mark
 * Grafikusan megjelen�thet� elem
 * Mivel mindegyik nagyj�b�l ugyanazt csin�lja, ez�rt itt foglalom �ssze
 * A DrawableConnection kiv�tel�vel minden ilyen oszt�ly egy k�rt rajzol
 * A k�rnek a k�z�ppontj�t, a sugar�t �s az egyedi azonos�t�j�t lehet megadni
 * A DrawableObject-eknek van egy referenci�ja arra a DrawableTile-ra, amin �llnak
 */
public interface Drawable {
	/**
	 * @param g2
	 * A g2 objektumra rajzolja mag�t
	 */
	public void Draw(Graphics2D g2);
}
