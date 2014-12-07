package towers;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import towerdefence.Engine;
import base.Bullet;
import base.Enemy;
import base.Entity;
import base.Tower;


public class Turret extends Entity {

	protected Tower tower;
	protected Entity target;
	protected int damage;
	protected float attackSpeed;
	
	public Turret(float x, float y, Image sprite, Tower tower, int damage, float attackSpeed) {
		super(x, y, sprite);
		this.damage = damage;
		this.attackSpeed = attackSpeed;
		this.tower = tower;
	}
	
	@Override
	public void update(GameContainer container, int delta)
			throws SlickException {
		if(target != null){
			lookAt(target);
			attack();
		}
	}

	@Override
	public void onAttack(int damage) {
		// TODO Auto-generated method stub
		
	}

	private float attackTimer = 18;
	private void attack() throws SlickException{
		if(attackTimer <= 0){
			if(target.exists()){
				attackTimer = 22;
				Bullet bullet = new Bullet(x, y, new Image("assets/particles/blood_fancy_small.png"), damage, target);
				Engine.instant.addEntity(bullet);
			}
		}else{
			attackTimer -= attackSpeed;
		}
	}

	public void checkTargets(ArrayList<Entity> targetsInRange) {
		int bestTargetDistance = 99999;
		Entity bestTarget = null;
		for(Entity entity : targetsInRange){
			if(entity instanceof Enemy){
				if(((Enemy) entity).getDistanceFromEntity(this) < bestTargetDistance){
					bestTarget = entity;
					bestTargetDistance = ((Enemy) entity).getHP();
				}
			}
		}
		this.target = bestTarget;
	}

}
