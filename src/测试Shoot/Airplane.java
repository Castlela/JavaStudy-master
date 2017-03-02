package 测试Shoot;

import java.util.Random;

public class Airplane extends FlyingObject implements Enemy {
	private int speed = 2;
	private int score = 5;
	
	public Airplane(){
		image = ShootGame.airplane;
		width = image.getWidth();
		height = image.getHeight();
		Random rand = new Random();
		x = rand.nextInt(ShootGame.WIDTH - width);
		y = -height;
	}
	
	@Override
	public int getScore() {
		return score;
	}
	
	@Override
	public void step(){
		y += speed;
	}

	@Override
	public boolean outSideBound() {
		return y >= ShootGame.HEIGHT;
	}

}
