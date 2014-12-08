package base;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;

import towerdefence.Engine;

public class Camera {
	public static float X;
	public static float Y;
	
	public static void translate(float x, float y){
		for(Entity entity : Engine.instant.entities){
			entity.translate(-x, -y);
		}
		X -= x;
		Y -= y;
	}
	
	public static void zoom(float dir){
		for(Entity entity : Engine.instant.entities){
			float scale = entity.getScale();
			entity.setScale(scale += dir);
		}
	}
	
	public static void update(GameContainer container, int delta){
		if(container.getInput().isKeyDown(Input.KEY_W)){
			//if(X )
			translate(0, -1);
		}
		if(container.getInput().isKeyDown(Input.KEY_A)){
			translate(-1, 0);
		}
		if(container.getInput().isKeyDown(Input.KEY_S)){
			translate(0, 1);
		}
		if(container.getInput().isKeyDown(Input.KEY_D)){
			translate(1, 0);
		}
	}
}
