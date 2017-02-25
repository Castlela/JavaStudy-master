package day13.shoot_画出对象;
import java.awt.image.BufferedImage;
import java.util.Random;
public class Hero extends FlyObject {
	private int life;
	private int doubleFire;
	private BufferedImage[] images;
	private int index;
	
	public Hero() {
		image = ShootGame.hero0;
		width = this.image.getWidth();
		height = this.image.getHeight();
		x = 150; //(ShootGame.background.getWidth()-width)/2;
		y = 400;
		life = 3;
		doubleFire = 0;
		images = new BufferedImage[]{ShootGame.hero0,ShootGame.hero1};
		index = 0;
	}
	
}
