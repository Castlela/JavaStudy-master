package day13.shoot_画出对象;

import java.util.Random;

/** 敌机是飞行物，也是敌人 */
public class Airplane extends FlyObject implements Enemy{
	private int ySpeed = 2; //走步的步数
	
	public Airplane() {
		image = ShootGame.airplane0;
		width = image.getWidth();
		height = image.getHeight();
		Random rand = new Random();
		x = rand.nextInt(ShootGame.WIDTH - this.width + 1);
		y = -this.height;
	}
	@Override
	public int getScore() { //打掉一个敌机得5分
		return 5;
	}
}
