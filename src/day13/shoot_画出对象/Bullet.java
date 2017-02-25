package day13.shoot_画出对象;

import java.util.Random;

public class Bullet extends FlyObject {
	private int ySpeed = 3;
	
	public Bullet(int x,int y) {
		image = ShootGame.bullet;
		width = image.getWidth();
		height = image.getHeight();
		this.x = x;
		this.y = y;
	}
}
