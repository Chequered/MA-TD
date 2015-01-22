package systementities;

import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class GridBlock {

	protected int screenX, screenY;
	protected int worldX, worldY;
	
	protected Shape hitBox;
	
	public GridBlock(int x, int y, int scale){
		worldX = x;
		worldY = y;
		screenX = x * scale;
		screenY = y * scale;
		hitBox = new Rectangle(screenX, screenY, scale, scale);
	}
	
	public int getWorldX(){
		return worldX;
	}
	
	public int getWorldY(){
		return worldY;
	}
	
	public Shape getHitBox(){
		return hitBox;
	}
}
