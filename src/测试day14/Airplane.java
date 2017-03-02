/** 敌机 = 加分*/
package 测试day14;

import java.util.Random;

public class Airplane extends FlyingObject implements Enemy {
	private int speed = 2; /** 从上往下的 加速度 */

	/** Airplane无参构造方法，用于初始化值*/
	public Airplane() {
		image = ShootGame.airplane; /** 设置airplane图片，在ShootGame中已用ImageIo类获得*/
		width = image.getWidth();   /** 保存图片的宽度 */
		height = image.getHeight(); /** 保存图片的高度 */
		Random rand = new Random(); /** 定随随机数对象 */
		this.x = rand.nextInt(ShootGame.WIDTH - width); /** 设置对象的x坐标位置*/
		//shoot02 变化
		this.y = -this.height;                          /** 设置对象的y坐标位置*/
		//this.y = 100;
	}
	
	/** 重写getScore()*/
	@Override /** 每次击中，获得5分*/
	public int getScore() {
		return 5;
	}
	
	/** 重写step()*/
	public void step(){
		y+=speed;
	}
	

}
