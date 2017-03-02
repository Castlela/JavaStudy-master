/** 子弹 */
package 测试day14;
public class Bullet extends FlyingObject {
	private int speed = 2; /** 从上往下 加速度 */
	
	/** 子弹出现的位置，跟随Hero，这里设为有参构造，用于获取坐标x,y */
	public Bullet(int x,int y) {
		image = ShootGame.bullet;  /** 设置Bullet图片，在ShootGame中已用ImageIo类获得*/
		width = image.getWidth();  /** 保存图片的宽度 */
		height = image.getHeight();/** 保存图片的高度 */
		this.x = x;                /** 接收来自参数x,作为x坐标*/
		this.y = y;                /** 接收来自参数y,作为y坐标*/
	}
	
	public void step(){
		y-=speed;
	}
	
}
