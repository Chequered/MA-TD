package systems;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

import systementities.GridBlock;
import towerdefence.Engine;
import towerdefence.Settings;
import base.Entity;

public class RenderSystem extends SystemBase {
	
	public static RenderSystem renderer;
	
	private GameContainer container;
	private Graphics g;
	
	private float scale = 1;
	private Shape renderBox = new Rectangle(0, 0, Settings.SCREEN_WIDTH, Settings.SCREEN_HEIGHT);
	
	public RenderSystem(){
		renderer = this;
	}
	
	@Override
	public void update(ArrayList<Entity> entities, GameContainer container,
			int delta) {
	}

	public void render(GameContainer container, Graphics g){
		this.container = container;
		this.g = g;
		g.scale(scale, scale);
		for(Entity entity : Engine.instant.entities){
			if(renderBox.intersects(entity.getHitbox())){
				entity.getSprite().draw(entity.getX() - entity.getWidth() / 2, entity.getY() - entity.getHeight() / 2, entity.getWidth() * entity.getScale(), entity.getHeight() * entity.getScale());
			}
		}
		if(container.getInput().isKeyDown(Input.KEY_Q)){
			scale += 0.001f;
		}
		if(container.getInput().isKeyDown(Input.KEY_E)){
			scale -= 0.001f;
		}
		for(GridBlock b : GridSystem.gridBlocks){
			RenderSystem.renderer.render(b.getHitBox(), b.getWorldX(), b.getWorldY());
		}
	}
	
	public void render(Shape s, int x, int y)
	{
		g.draw(s);
	}
	
}
