package day15.shoot3_开打;

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
	
	public void addLife(){
		life++;
	}
	public void substractLife(){
		life--;
	}
	
	public int getLife(){
		return life;
	}
	
	public void addDoubleFire(){
		doubleFire+=40;
	}
	
	public void clearDoubleFire(){
		doubleFire = 0;
	}
	
	public int getDoubleFire(){
		return doubleFire;
	}
	
	public boolean hit(FlyingObject obj){
		int x1 = obj.x - this.width/2;
		int x2 = obj.x + obj.width + this.width/2;
		int y1 = obj.y - this.height/2;
		int y2 = obj.y + obj.height + this.height/2;
		
		int x = this.x + this.width/2; //中心点X坐标
		int y = this.y + this.height/2; 
		
		return x>x1 && x<x2
				&&
				y>y1 && y<y2;
		
		/*int x1 = this.x;
		int x2 = this.x+this.width;
		int y1 = this.y;
		int y2 = this.y+this.height;
		
		int x = obj.x;
		int x0 = obj.x+obj.width;
		int y = obj.y;
		int y0 = obj.y+obj.height;
		
		return x>x1 && x<x2
				&&
			   y>y1 && y<y2
			   ||
			   x0>x1 && x0<x2
			   &&
			   y0>y1 && y0<y2; */
	}
	
}
