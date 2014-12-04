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

	private Engine _engine;
	
	@Override
	public void init(GameContainer container, StateBasedGame sbg)
			throws SlickException {
		
		_engine = new Engine();
		
		Enemy test = new Enemy(300, 300, new Image("assets/people/player.png"));
		_engine.addEntity(test);
		
		Tower tower = new MachineGunTower(200, 100, new Image("assets/tower/tower_base.png"), new Image("assets/tower/tower_turret.png"));
		_engine.addEntity(tower);
		tower.setScale(0.3f);
		
		//Tower tower2 = new MachineGunTower(500, 220, new Image("assets/tower/tower_base.png"), new Image("assets/tower/tower_turret.png"));
		//_engine.addEntity(tower2);
		//tower2.setScale(0.3f);
		
		//Tower tower3 = new MachineGunTower(300, 70, new Image("assets/tower/tower_base.png"), new Image("assets/tower/tower_turret.png"));
		//_engine.addEntity(tower3);
		//tower3.setScale(0.3f);
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
			Tower tower = new MachineGunTower(container.getInput().getMouseX() + Camera.X, container.getInput().getMouseY() + Camera.Y, new Image("assets/tower/tower_base.png"), new Image("assets/tower/tower_turret.png"));
			_engine.addEntity(tower);
		}
	}
	
	@Override
	public int getID() {
		return 0;
	}
}
