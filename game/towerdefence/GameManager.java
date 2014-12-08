package towerdefence;

import java.util.Iterator;

import org.newdawn.slick.GameContainer;

import base.Entity;

public class GameManager{

	public int gold = 0;
	
	public GameManager(){
		
	}
	
	public void update(GameContainer container, int delta){
		for (Iterator<Entity> iterator = Engine.instant.entities.iterator(); iterator.hasNext();) {
		    Entity entity = iterator.next();
		    if (!entity.isAlive()) {
		        iterator.remove();
		        entity.kill();
		    }
		}
	}
}
