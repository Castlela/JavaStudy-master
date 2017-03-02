/** 小蜜蜂 = 奖励 */
package day13.shoot01_画对象;

import java.util.Random;

public class Bee extends FlyingObject implements Award {
	private int xSpeed = 2; /** 左右 加速度 */
	private int ySpeed = 3; /** 从上往下 加速度 */
	private int awardType;  /** 奖励类型 */
	
	/** Bee无参构造方法，用于初始化值*/
	public Bee() {
		image = ShootGame.bee;     /** 设置Bee图片，在ShootGame中已用ImageIo类获得*/
		width = image.getWidth();  /** 保存图片的宽度 */
		height = image.getHeight();/** 保存图片的高度 */
		Random rand = new Random();/** 定随随机数对象 */
		this.x = rand.nextInt(ShootGame.WIDTH - width); /** 设置对象的x坐标位置*/
		//this.y = -this.height;                        /** 设置对象的y坐标位置*/
		this.y = 200;
		awardType = rand.nextInt(2); /** 设置随机的奖励类型 */
	}
	
	@Override /** 获得奖励的类型*/
	public int getType() {
		return awardType;
	}

}
