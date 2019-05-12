package projlabhazi;

import java.awt.Graphics;

public abstract class DrawableObject implements Drawable {
	protected int id;
	protected DrawableTile tile;
	public static int radius = 20;
	public static int idCounter = -1;
	
	public DrawableObject(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public DrawableTile getTile() {
		return tile;
	}
	
	public void setTile(DrawableTile tile) {
		this.tile = tile;
	}
	
}
