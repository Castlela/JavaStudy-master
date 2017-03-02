/** 英雄机 */
package day13.shoot01_画对象;
import java.awt.image.BufferedImage;
import java.util.Random; /** BufferedImage读取图片类*/
public class Hero extends FlyingObject {
	private int doubleFire; /** 双倍火力值 */
	private int life; /** 生命值  */
	private BufferedImage[] images; /** 动态英雄机图片 */
	private int index; /** 辅助英雄机图片 切换*/
	
	/** Hero无参构造方法，用于初始化值*/
	public Hero() {
		image = ShootGame.hero0;   /** 设置Bee图片，在ShootGame中已用ImageIo类获得*/
		width = image.getWidth();  /** 保存图片的宽度 */
		height = image.getHeight();/** 保存图片的高度 */
		Random rand = new Random();/** 定随随机数对象 */
		this.x = 150;              /** 设置默认的x坐标 */
		this.y = 400;              /** 设置默认的y坐标 */
		doubleFire = 0;            /** 默认单倍火力 */
		life = 3;                  /** 默认有三条命 */
		images = new BufferedImage[]{ShootGame.hero0,ShootGame.hero1}; /** Hero图片有两张，由于设置动态效果*/
		index = 0; /** 默认显示下标为0的图片 */
	}
	
}
