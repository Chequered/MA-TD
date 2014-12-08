package base;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Bullet extends Entity{

	protected Entity target;
	protected boolean homing = true;
	protected int damage;
	
	public Bullet(float x, float y, Image sprite, int damage, Entity target) {
		super(x, y, sprite);
		this.damage = damage;
		this.target = target;
	}

	@Override
	public void update(GameContainer container, int delta)
			throws SlickException {
		if(homing){
			if(target != null){
				lookAt(target);
				x += moveForward().x * 2;
				y += moveForward().y * 2;
				if(target.getDistanceFromEntity(this) < 2.5f){
					target.onAttack(damage);
					this.kill();
				}
			}
		}
	}
	
	@Override
	public void onAttack(int damage) {
		// TODO Auto-generated method stub
		
	}

}
