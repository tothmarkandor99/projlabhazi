package projlabhazi;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DrawableTile implements Drawable {
	private final int id;
	private int x, y;
	public static int radius = 20;
	
	public DrawableTile(int id, int x, int y){
		this.id = id;
		this.x = x;
		this.y = y;
	}
	
	@Override
	public void Draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(Color.LIGHT_GRAY);
		g2.fillOval(x - radius / 2, y - radius / 2, radius * 2, radius * 2);
	}

	public int getId(){
		return id;
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
