package states;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import base.Camera;
import base.Enemy;
import base.Tower;
import towerdefence.Engine;
import towerdefence.Main;
import towers.MachineGunTower;

public class GameState extends BasicGameState {

	public static final float LEVEL_WIDTH = 2000;
	public static final float LEVEL_HEIGHT = 2000;
	
	private Engine _engine;
	
	@Override
	public void init(GameContainer container, StateBasedGame sbg)
			throws SlickException {
		
		_engine = new Engine();
	}
	
	@Override
	public void update(GameContainer container, StateBasedGame sbg, int delta)
			throws SlickException {
		_engine.update(container, delta);
		getGlobalInput(container); //get keyboard / mouse input used for pausing / menus etc		
	}
		
	@Override
	public void render(GameContainer container, StateBasedGame state, Graphics g)
			throws SlickException {
		_engine.render(container, g);
	}
	
	private void getGlobalInput(GameContainer container) throws SlickException{
		if(container.getInput().isKeyDown(Input.KEY_ESCAPE)){
			if(Main.application.isFullscreen()){
				Main.application.setFullscreen(false);
			}
		}
		if(container.getInput().isMousePressed(0)){
			Enemy test = new Enemy(container.getInput().getMouseX(), container.getInput().getMouseY(), new Image("assets/people/player.png"));
			_engine.addEntity(test);
		}
		if(container.getInput().isMousePressed(1)){
			Tower tower = new MachineGunTower(container.getInput().getMouseX(), container.getInput().getMouseY(), new Image("assets/tower/tower_base.png"), new Image("assets/tower/tower_turret.png"));
			_engine.addEntity(tower);
			tower.setScale(0.45f);
		}
	}
	
	@Override
	public int getID() {
		return 0;
	}
}
