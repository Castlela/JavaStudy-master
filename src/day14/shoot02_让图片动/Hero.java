package day14.shoot02_让图片动;

import java.awt.image.BufferedImage;

public class Hero extends FlyingObject {
	private int doubleFire;
	private int life;
	private BufferedImage[] images;
	private int index;
	
	public Hero() {
		image = ShootGame.hero0;
		width = image.getWidth();
		height = image.getHeight();
		x = 150;
		y = 400;
		doubleFire = 10;
		life = 3;
		images = new BufferedImage[]{ShootGame.hero0,ShootGame.hero1};
		index = 0;
	}
	
	@Override
	public void step() {
		index++;
		int a = index/10;
		int b = a%2;
		image = images[b];
	}
	
	public Bullet[] shoot(){
		int xStep = width/4;
		int yStep = 20;
		if(doubleFire>0){
			Bullet[] bs = new Bullet[2];
			bs[0] = new Bullet(x+xStep,y-yStep);
			bs[1] = new Bullet(x+3*xStep,y-yStep);
			doubleFire-=2;
			return bs;
		}else{
			Bullet[] bs = new Bullet[1];
			bs[0] = new Bullet(x+2*xStep,y-yStep);
			return bs;
		}
	}
	
	public void moveTo(int x,int y){
		this.x = x-this.width/2;
		this.y = y-this.height/2;
	}

	@Override
	public boolean outOfBounds() {
		return false;
	}
	
	

}
