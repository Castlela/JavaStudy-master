package day15.shoot3_开打;

import java.util.Random;

public class Bee extends FlyingObject implements Award {
	private int xSpeed = 2;
	private int ySpeed = 2;
	private int awardType;
	
	public Bee() {
		image = ShootGame.bee;
		width = image.getWidth();
		height = image.getHeight();
		Random rand = new Random();
		x = rand.nextInt(ShootGame.WIDTH-width);
		y = -height;
		awardType = rand.nextInt(2);
	}
	
	@Override
	public int getType() {
		return awardType;
	}

	@Override
	public void step() {
		x+=xSpeed;
		y+=ySpeed;
		if(x>=ShootGame.WIDTH-width){
			xSpeed = -1;
		}else if(x<=0){
			xSpeed = 1;
		}
	}

	@Override
	public boolean outOfBounds() {
		return this.y>=ShootGame.HEIGHT;
	}

}
