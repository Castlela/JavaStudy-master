package day15.shoot3_开打;

import java.util.Random;

public class Airplane extends FlyingObject implements Enemy {
	private int speed = 2;
	
	public Airplane() {
		image = ShootGame.airplane;
		width = image.getWidth();
		height = image.getHeight();
		Random rand = new Random();
		x = rand.nextInt(ShootGame.WIDTH - width);
		y = -height;
	}
	
	@Override
	public int getScore() {
		return 5;
	}

	@Override
	public void step() {
		y+=speed;
	}

	@Override
	public boolean outOfBounds() {
		return this.y>=ShootGame.HEIGHT;
	}

}
