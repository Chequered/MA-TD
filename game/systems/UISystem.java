package systems;

import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.fills.GradientFill;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

import towerdefence.Engine;
import towerdefence.Settings;
import base.Entity;

public class UISystem extends SystemBase{

	//GUIBG
	private Shape GUIBG;
	private GradientFill GUIBGFill;
	private float BGWidth = Settings.SCREEN_WIDTH;
	private float BGHeight = 140;
	
	public UISystem(){
		GUIBG = new Rectangle(0, Settings.SCREEN_HEIGHT - BGHeight, BGWidth, BGHeight);
		GUIBGFill = new GradientFill(50, 12, Color.gray, 120, 42, Color.gray);
	}
	
	@Override
	public void update(ArrayList<Entity> entities, GameContainer container,
			int delta) {
		// TODO Auto-generated method stub
		
	}

	public void render(GameContainer container, Graphics g){
		g.fill(GUIBG, GUIBGFill);
		g.draw(GUIBG);
		g.drawString("Gold: " + Engine.instant.gm.gold, GUIBG.getX() + 10, GUIBG.getY() + 10);
	}
	
}
