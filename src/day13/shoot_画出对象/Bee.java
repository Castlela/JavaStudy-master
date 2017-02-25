package day13.shoot_画出对象;

import java.util.Random;

public class Bee extends FlyObject implements Award {
	private int xSpeed = 1;
	private int ySpeed = 2; //y坐标走步步数
	private int awardType; //奖励类型
	
	public Bee() {
		image = ShootGame.bee0;
		width = image.getWidth();
		height = image.getHeight();
		Random rand = new Random();
		x = rand.nextInt(ShootGame.WIDTH - this.width + 1);
		y = -this.height;
		awardType = rand.nextInt(2);
	}
	@Override
	public int getType() {
		return awardType; //返回奖励类型
	}
	
}
