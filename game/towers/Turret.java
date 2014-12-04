package towers;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import base.Entity;


public class Turret extends Entity {

	protected Entity target;
	
	public Turret(float x, float y, Image sprite) {
		super(x, y, sprite);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(GameContainer container, int delta)
			throws SlickException {
		if(target != null){
			lookAt(target);
			out.println("looking");
		}
	}

	@Override
	public void onAttack(int damage) {
		// TODO Auto-generated method stub
		
	}

	public void setTarget(Entity entity) {
		this.target = entity;
	}

}
