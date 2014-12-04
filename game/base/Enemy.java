package base;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Shape;

import towerdefence.Engine;

public class Enemy extends Entity{

	public static final float TIME_ATTACK_BASE = 18;
	
	//Data
	protected Entity target;
	protected Shape rangeBox;
	
	//Stats
	protected int hp;
	protected int damage = 7;
	protected float movementSpeed = 0.1f;
	protected float attackSpeed = 0.2f;
	
	//switches
	protected boolean inRange;
	
	public Enemy(float x, float y, Image sprite) {
		super(x, y, sprite);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(GameContainer container, int delta)
			throws SlickException {
		if(target != null){
			lookAt(target);
			moveToTarget();
			if(inRange){
				attack();
			}
			if(!target.isAlive()){
				seekTarget(Engine.instant.entities);
			}
		}else{
			seekTarget(Engine.instant.entities);
		}
	}

	@Override
	public void onAttack(int damage) {
		// TODO Auto-generated method stub
		
	}

	public void setStats(int hp, int damage){
		this.hp = hp;
		this.damage = damage;
	}
	
	public int getHP(){
		return this.hp;
	}
	
	public int getDamage(){
		return this.damage;
	}
	
	private void moveToTarget(){
		if(getDistanceFromEntity(target) > 20 )
		{
			x += moveForward().x * movementSpeed;
			y += moveForward().y * movementSpeed;
			inRange = false;
		}else{
			inRange = true;
		}
	}
	
	private float attackTimer = TIME_ATTACK_BASE;
	private void attack(){
		if(attackTimer <= 0){
			target.onAttack(damage);
			attackTimer = TIME_ATTACK_BASE;
		}else{
			attackTimer -= attackSpeed;
		}
	}
	
	public void seekTarget(ArrayList<Entity> entities){
		float currentTop = 99999;
		for(Entity entity : entities){
			if(entity instanceof Tower){
				if(entity.getDistanceFromEntity(this) < currentTop){
					target = entity;
					currentTop = entity.getDistanceFromEntity(this);
				}
			}
		}
	}
}
