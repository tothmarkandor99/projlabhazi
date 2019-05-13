package projlabhazi;

import java.awt.Graphics2D;

/**
 * @author Mark
 * Grafikusan megjeleníthetõ elem
 * Mivel mindegyik nagyjából ugyanazt csinálja, ezért itt foglalom össze
 * A DrawableConnection kivételével minden ilyen osztály egy kört rajzol
 * A körnek a középpontját, a sugarát és az egyedi azonosítóját lehet megadni
 * A DrawableObject-eknek van egy referenciája arra a DrawableTile-ra, amin állnak
 */
public interface Drawable {
	/**
	 * @param g2
	 * A g2 objektumra rajzolja magát
	 */
	public void Draw(Graphics2D g2);
}
