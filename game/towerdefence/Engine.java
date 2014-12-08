package towerdefence;

import java.util.ArrayList;

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

	public static final String VERSION_NUMBER = "0.0.3"; // Release, Week, Day
	public static final String WINDOW_NAME = "Tower Defence " + VERSION_NUMBER;
	public static final boolean renderHitboxes = false;
	
	public static Engine instant;
	
	public ArrayList<Entity> entities = new ArrayList<Entity>();
	
	private ArrayList<SystemBase> systems = new ArrayList<SystemBase>();
	
	public GameManager gm = new GameManager();
	public RenderSystem rs = new RenderSystem();
	
	public Engine() throws SlickException{
		instant = this;
		
		systems.add(new CollisionSystem());
		systems.add(rs);
		systems.add(new UISystem());
		
	}
	
	public void addEntity(Entity entity){
		entities.add(entity);
		entity.setID(entities.size() + 1);
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
	}
	
	public void render(GameContainer container, Graphics g) throws SlickException{
		for (Entity entity : entities){
			entity.render(container, g);
		}
		for(SystemBase sys : systems){
			sys.render(container, g);
		}
	}
	
	public static void log(String txt){
		System.out.println(txt);
	}
	
}
