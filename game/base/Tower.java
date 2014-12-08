package base;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;

import towerdefence.Engine;
import towers.Turret;

public abstract class Tower extends Entity{

	protected int hp = 50;
	protected int damage = 12;
	protected float range = 125;
	protected float attackSpeed = 0.9f;
	
	protected Turret turret;
	
	public Tower(float x, float y, Image base) {
		super(x, y, base);
		// TODO Auto-generated constructor stub
	}
	
	public Tower(float x, float y, Image base, Image turret) {
		super(x, y, base);
		// TODO Auto-generated constructor stub
		this.turret = new Turret(x, y, turret, this, damage, attackSpeed);
		Engine.instant.addEntity(this.turret);
	}

	@Override
	public void update(GameContainer container, int delta){
		if(turret != null){
			checkTargets();
		}
	}

	@Override
	public void render(GameContainer container, Graphics g)
			throws SlickException {
		super.render(container, g);
		g.drawString("" + hp, x, y);
		if(hitbox != null){
			g.draw(hitbox);			
		}
	}
	
	@Override
	public void onAttack(int damage) {
		this.hp -= damage;
		if(this.hp <= 0){
			kill();
		}
	}
	
	public void setDefaultStats(int hp, int damage, float range){
		this.hp = hp;
		this.damage = damage;
		this.range = range;
		this.hitbox = new Circle(x, y, range);
	}
	
	@Override
	public void setPos(float x, float y){
		super.setPos(x, y);
		this.hitbox.setX(x);
		this.hitbox.setY(y);
	}
	
	@Override
	public void kill(){
		if(turret != null){
			turret.kill();
		}
		super.kill();
	}
	
	@Override
	public void setScale(float scale){
		super.setScale(scale);
		turret.setScale(scale);
	}
	
	public void checkTargets(){
		ArrayList<Entity> targetsInRange = new ArrayList<Entity>();
		for(Entity entity : Engine.instant.entities){
			if(entity instanceof Enemy){
				if(entity.getDistanceFromEntity(this) < this.range){
					targetsInRange.add(entity);
					turret.checkTargets(targetsInRange);
				}
			}
		}
	}
	
}
