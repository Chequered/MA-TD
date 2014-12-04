package base;

import java.io.PrintStream;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Vector2f;

import towerdefence.Engine;

public abstract class Entity {
	
	protected int ID;
	protected float x;
	protected float y;
	protected float width;
	protected float height;
	protected Image sprite;
	protected Shape hitbox;
	protected boolean visable = true;
	protected float scale;
	protected boolean alive = true;
	
	protected PrintStream out;
	
	public Entity(float x, float y, Image sprite){
		this.x = x;
		this.y = y;
		this.sprite = sprite;
		this.width = sprite.getWidth();
		this.height = sprite.getHeight();	
		this.visable = true;
		this.scale = 1;
		this.hitbox = new Rectangle(x, y, width * scale, height * scale);
		this.hitbox.setCenterX(x);
		this.hitbox.setCenterY(y);
		this.out = System.out;
	}

	public abstract void update(GameContainer container, int delta) throws SlickException;
	
	public void render(GameContainer container, Graphics g) throws SlickException{
		if(Engine.renderHitboxes){
			g.draw(hitbox);			
		}
	}
	
	public void setPos(float x, float y){
		this.x = x;
		this.y = y;
		this.hitbox.setCenterX(x);
		this.hitbox.setCenterY(y);
	}
	
	public void setID(int id){
		this.ID = id;
	}
	
	public float getX(){
		return x;
	}
	
	public float getY(){
		return y;
	}
	
	public float getWorldX(){
		return this.x - Camera.X;
	}
	
	public float getWorldY(){
		return this.y - Camera.Y;		
	}
	
	public float getWidth(){
		return this.width;
	}
	
	public float getHeight(){
		return this.height;
	}
	
	public int getID(){
		return this.ID;
	}
	
	public Shape getHitbox(){
		return this.hitbox;
	}
	
	public Image getSprite(){
		return this.sprite;
	}
	
	public void setScale(float scale){
		this.scale = scale;
		this.width = sprite.getWidth() * scale;
		this.height = sprite.getHeight() * scale;
	}
	
	public float getScale(){
		return this.scale;
	}
	
	public abstract void onAttack(int damage);

	public void OnCollision(Entity entity) {
		//Semi abstract
	}
	
	public void lookAt(Entity entity){
		float xDistance = entity.getX() - x;
		float yDistance = entity.getY() - y;
		double angleToTurn = Math.toDegrees(Math.atan2(yDistance, xDistance));
		sprite.setRotation((float)angleToTurn);
	}
	
	public Vector2f moveForward(){
		
		float mX = (float) Math.cos(Math.toRadians(sprite.getRotation()));
		float mY = (float) Math.sin(Math.toRadians(sprite.getRotation()));
		
		float vX = mX;
		float vY = mY;
		
		this.x += vX;
		this.y += vY;
		
		return new Vector2f(vX, vY);
	}
	
	public Vector2f getLPosition(){
		return new Vector2f(x,y);
	}
	
	public float getDistanceFromEntity(Entity entity){
		return (float) Math.sqrt((x-entity.getX())*(x-entity.getX()) + (y-entity.getY())*(y-entity.getY()));
	}
	
	public boolean isAlive(){
		return this.alive;
	}

	public void kill() {
		this.alive = false;
	}
	
}
