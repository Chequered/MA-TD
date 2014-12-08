package towerdefence;

import java.util.ArrayList;
import java.util.Iterator;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import systems.CollisionSystem;
import systems.RenderSystem;
import systems.SystemBase;
import systems.UISystem;
import base.Camera;
import base.Entity;

public class Engine {

	public static final String VERSION_NUMBER = "0.0.4"; // Release, Week, Day
	public static final String WINDOW_NAME = "Tower Defence " + VERSION_NUMBER;
	public static final boolean renderHitboxes = false;
	
	public static Engine instant;
	
	public ArrayList<Entity> entities = new ArrayList<Entity>();
	public ArrayList<Entity> entityQueue = new ArrayList<Entity>();
	public ArrayList<Entity> destroyQueue = new ArrayList<Entity>();	
	
	private ArrayList<SystemBase> systems = new ArrayList<SystemBase>();
	
	public GameManager gm;
	public RenderSystem rs;
	
	public Engine() throws SlickException{
		instant = this;
		
		gm = new GameManager();
		rs = new RenderSystem();
		
		systems.add(new CollisionSystem());
		systems.add(rs);
		systems.add(new UISystem());
		
	}
	
	public void addEntity(Entity entity){
		entityQueue.add(entity);
		entity.setID(entities.size() + 1);
	}
	
	public void destroyEntity(Entity object){
		destroyQueue.add(object);
	}
	
	public void update(GameContainer container, int delta) throws SlickException{
		for (Entity entity : entities){
			entity.update(container, delta);
		}
		for(SystemBase sys : systems){
			sys.update(entities, container, delta);
		}
		if(gm != null){
			gm.update(container, delta);
		}
		Camera.update(container, delta);
		entities.addAll(entityQueue);
		entities.removeAll(destroyQueue);
		entityQueue.clear();
		destroyQueue.clear();
	}
	
	public void render(GameContainer container, Graphics g) throws SlickException{
<<<<<<< HEAD
		for (Entity entity : entities){
			entity.render(container, g);
		}
		for(SystemBase sys : systems){
			sys.render(container, g);
		}
=======
		gm.render(container, g);
		rs.render(container, g);
>>>>>>> origin/master
	}
	
	public static void log(String txt){
		System.out.println(txt);
	}
	
}
