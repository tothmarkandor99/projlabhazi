package projlabhazi;

import java.awt.Graphics2D;

/**
 * @author Mark
 * Grafikusan megjeleníthetõ elem
 */
public interface Drawable {
	/**
	 * @param g2
	 * A g2 objektumra rajzolja magát
	 */
	public void Draw(Graphics2D g2);
}
