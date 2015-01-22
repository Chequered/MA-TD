package systems;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;

import systementities.GridBlock;
import base.Entity;

public class GridSystem extends SystemBase{

	public static final int basePixelSize = 50;
	
	public static int gridWidth = 40;
	public static int gridHeight = 40;
	
	public static ArrayList<GridBlock> gridBlocks = new ArrayList<GridBlock>();
	
	public GridSystem(){
		for(int x = 0; x < gridWidth; x ++){
			for(int y = 0; y < gridHeight; y++){
				GridBlock block = new GridBlock(x, y, basePixelSize);
				gridBlocks.add(block);
			}
		}
	}
	
	@Override
	public void update(ArrayList<Entity> entities, GameContainer container,
			int delta) {
	}
}
