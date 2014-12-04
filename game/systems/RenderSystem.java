package systems;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import towerdefence.Engine;
import base.Camera;
import base.Entity;

public class RenderSystem extends SystemBase {
	
	@Override
	public void update(ArrayList<Entity> entities, GameContainer container,
			int delta) {
	}

	public void render(GameContainer container, Graphics g){
		for(Entity entity : Engine.instant.entities){
			entity.getSprite().draw(entity.getX() - Camera.X - entity.getWidth() / 2, entity.getY() - Camera.Y - entity.getHeight() / 2, entity.getWidth() * entity.getScale(), entity.getHeight() * entity.getScale());
		}
	}
	
}
