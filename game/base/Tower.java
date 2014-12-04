package base;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;

import towerdefence.Engine;
import towers.Turret;

public abstract class Tower extends Entity{

	protected int hp = 50;
	protected int damage = 2;
	protected float range = 120;
	
	protected Shape rangeBox = new Circle(x, y, range);
	protected Turret turret;
	
	protected ArrayList<Entity> targetsInRange = new ArrayList<Entity>();
	
	public Tower(float x, float y, Image base, Image turret) {
		super(x, y, base);
		// TODO Auto-generated constructor stub
		this.turret = new Turret(x, y, turret);
		Engine.instant.addEntity(this.turret);
	}

	@Override
	public abstract void update(GameContainer container, int delta) throws SlickException;

	@Override
	public void render(GameContainer container, Graphics g)
			throws SlickException {
		super.render(container, g);
		out.println("size:" + targetsInRange.size());
		g.drawString("" + hp, getWorldX(), getWorldY());
		if(rangeBox != null){
			g.draw(rangeBox);			
		}
	}
	
	@Override
	public void onAttack(int damage) {
		this.hp -= damage;
		if(this.hp <= 0){
			this.alive = false;
		}
	}
	
	public void setDefaultStats(int hp, int damage, float range){
		this.hp = hp;
		this.damage = damage;
		this.range = range;
		this.rangeBox = new Circle(x, y, range);
	}
	
	@Override
	public void setPos(float x, float y){
		super.setPos(x, y);
		this.rangeBox.setX(x);
		this.rangeBox.setY(y);
	}
	
	public void shoot(){
		
	}

	public Shape getRangeBox(){
		return rangeBox;
	}
	
	public void addTargetInRange(Entity target){
		targetsInRange.add(target);
	}
	
	@Override
	public void kill(){
		super.kill();
		turret.kill();
	}
	
	@Override
	public Shape getHitbox(){
		return this.rangeBox;
	}
	
	@Override
	public void setScale(float scale){
		super.setScale(scale);
		turret.setScale(scale);
	}
	
	public void checkTowers(Entity entity){
		// check distance to all towers
	}
	
}
