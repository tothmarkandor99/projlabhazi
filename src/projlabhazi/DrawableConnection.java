package projlabhazi;

import java.awt.Graphics;

public class DrawableConnection implements Drawable {
	DrawableTile from, to;
	
	public DrawableConnection(DrawableTile from, DrawableTile to) {
		this.from = from;
		this.to = to;
	}

	@Override
	public void Draw(Graphics g) {
		// TODO: line stroke
		g.drawLine(from.getX(), from.getY(), to.getX(), to.getY());
		// TODO: arrow end
	}

}
