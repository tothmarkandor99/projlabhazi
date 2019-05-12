package projlabhazi;

import java.awt.Graphics;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DrawableTile extends Tile implements Drawable {
	private int x, y, radius;
	
	public DrawableTile(Tile tile){
		super(tile);
	}
	
	@Override
	public void Draw(Graphics g) {
		// TODO: stroke, fill
		g.drawOval(x - radius / 2, y - radius / 2, radius * 2, radius * 2);
		g.fillOval(x - radius / 2, y - radius / 2, radius * 2, radius * 2);
	}

	public int getX(){
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void saveToFile(ObjectOutputStream out) throws IOException {
		out.writeInt(x);
		out.writeInt(y);
		out.writeInt(radius);
	}
	
	public void loadFromFile(ObjectInputStream in) throws IOException {
		x = in.readInt();
		y = in.readInt();
		radius = in.readInt();
	}
}
