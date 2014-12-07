package systems;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;

import base.Entity;

public class CollisionSystem extends SystemBase{
	
	private void checkEntities(Entity entity, ArrayList<Entity> entities){
		for(Entity ent : entities){
			if(entity.getHitbox().intersects(ent.getHitbox())){
				entity.onCollision(ent);
				ent.onCollision(entity);
			}
		}
	}

	@Override
	public void update(ArrayList<Entity> entities, GameContainer container, int delta) {
		for(Entity entity : entities){
			checkEntities(entity, entities);
		}
		
	}
	
}
