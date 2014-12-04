package systems;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;

import base.Entity;

public abstract class SystemBase {
	
	public abstract void update(ArrayList<Entity> entities, GameContainer container, int delta);
}
