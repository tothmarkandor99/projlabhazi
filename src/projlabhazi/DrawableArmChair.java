package projlabhazi;

import java.awt.Color;
import java.awt.Graphics2D;

public class DrawableArmChair extends DrawableObject {
	public static int radius = 20;
	private DrawablePanda panda;
	
	public DrawableArmChair(int id) {
		super(id);
		panda = null;
	}

	@Override
	public void Draw(Graphics2D g2) {
		g2.setColor(new Color(255, 230, 153));
		g2.fillOval(tile.getX() - radius, tile.getY() - radius, radius * 2, radius * 2);
		if (panda != null)
			panda.Draw(g2);
	}
	
	public void setPanda(DrawablePanda panda) {
		this.panda = panda;
		if (panda != null) {
			panda.setTile(tile);
		}
	}

}
