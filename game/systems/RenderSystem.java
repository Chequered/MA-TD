package systems;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

import towerdefence.Engine;
import base.Camera;
import base.Entity;
import base.Tower;

public class RenderSystem extends SystemBase {
	
	private float scale = 1;
	
	@Override
	public void update(ArrayList<Entity> entities, GameContainer container,
			int delta) {
	}

	public void render(GameContainer container, Graphics g){
		g.scale(scale, scale);
		for(Entity entity : Engine.instant.entities){
			entity.getSprite().draw(entity.getX() - entity.getWidth() / 2, entity.getY() - entity.getHeight() / 2, entity.getWidth() * entity.getScale(), entity.getHeight() * entity.getScale());
		}
		if(container.getInput().isKeyDown(Input.KEY_Q)){
			scale += 0.001f;
		}
		if(container.getInput().isKeyDown(Input.KEY_E)){
			scale -= 0.001f;
		}
	}
	
}
