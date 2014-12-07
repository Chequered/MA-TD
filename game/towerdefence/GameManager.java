package towerdefence;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import towers.HeadQuarters;
import base.Entity;
import base.Tower;

public class GameManager{

	public HeadQuarters hq;
	
	public GameManager() throws SlickException{
		hq = new HeadQuarters(Settings.SCREEN_WIDTH / 2, Settings.SCREEN_HEIGHT / 2, new Image("assets/tower/hq.png"));
		Engine.instant.addEntity(hq);
	}
	
	public void update(GameContainer container, int delta){
	
	}
	
	public void render(GameContainer container, Graphics g){
		for(Entity tower : Engine.instant.entities){
			if(tower instanceof Tower){
				g.drawLine(tower.getX(), tower.getY(), hq.getX(), hq.getY());
			}
		}
	}
	
	public void shoot(Entity bullet){
		Engine.instant.entities.add(bullet);
	}
}
