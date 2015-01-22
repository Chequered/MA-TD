package systems;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import base.Entity;

public abstract class SystemBase {
	
	public abstract void update(ArrayList<Entity> entities, GameContainer container, int delta);

	public abstract void render(GameContainer container, Graphics g);
}
