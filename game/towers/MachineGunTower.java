package towers;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import base.Tower;

public class MachineGunTower extends Tower{

	public MachineGunTower(float x, float y, Image sprite, Image turret) {
		super(x, y, sprite, turret);

		setDefaultStats(hp, damage, range);
	}

	
	public void update(GameContainer container, int delta) {
		super.update(container, delta);
		
	}

}
