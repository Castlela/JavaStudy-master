package day13.shoot01_画对象;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class ShootGame extends JPanel {
	public static final int WIDTH = 400; /** 设置JFrame的宽 */
	public static final int HEIGHT = 654;/** 设置JFrame的高 */
	
	/** 设置游戏的所有图片变量 */
	public static BufferedImage background; 
	public static BufferedImage start;
	public static BufferedImage pause;
	public static BufferedImage gameover;
	public static BufferedImage airplane;
	public static BufferedImage bee;
	public static BufferedImage bullet;
	public static BufferedImage hero0;
	public static BufferedImage hero1;
	
	/** 声明要显示的对象*/
	public Hero hero = new Hero();       /** 英雄机 */
	public FlyingObject[] flyings = {};  /** 敌机+蜜蜂 */
	public Bullet bullets[] = {};        /** 子弹 */
	
	/** 启动本程序时，初始化所有要显示的对象*/
	public ShootGame() {
		/** 利用多态方式设计，增加程序扩展性*/
		flyings = new FlyingObject[2];
		flyings[0] = new Airplane();
		flyings[1] = new Bee();
		bullets = new Bullet[1];
		bullets[0] = new Bullet(100,200);
	}
	
	/** 不探讨继承的情况，带static的变量、块、方法，在加载类的时候率先执行，然后再到成员变量定义，再到构造方法 */
	static{ 
		try{/**JAVA规定IO流容易出错，因此要加上try catch类，做异常处理，这里是初始化所有图片变量*/
			background = ImageIO.read(ShootGame.class.getResource("background.png"));
			start = ImageIO.read(ShootGame.class.getResource("start.png"));
			pause = ImageIO.read(ShootGame.class.getResource("pause.png"));
			gameover = ImageIO.read(ShootGame.class.getResource("gameover.png"));
			airplane = ImageIO.read(ShootGame.class.getResource("airplane.png"));
			bee = ImageIO.read(ShootGame.class.getResource("bee.png"));
			bullet = ImageIO.read(ShootGame.class.getResource("bullet.png"));
			hero0 = ImageIO.read(ShootGame.class.getResource("hero0.png"));
			hero1 = ImageIO.read(ShootGame.class.getResource("hero1.png"));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Override /** paint类，只能被系统自动调用，不能手动执行 frame.setVisable可以要求系统尽快调用 */
	public void paint(Graphics g) {
		System.out.println(333);
		/** 
		 * 参数1:图片变量，
		 * 参数2:图片的原点x坐标
		 * 参数3:图片的原点y坐标
		 * 参数4:暂时用不到
		 */
		g.drawImage(background, 0, 0, null); /** 写入背景图 */ 
		paintFlyingObject(g); 	             /** 调用自定义方法 写入敌机+蜜蜂*/
		paintHero(g);                        /** 调用自定义方法 写入英雄机 */
		paintBullet(g);                      /** 调用自定义方法 写入子弹 */
	}
	/** 以下带paint的方法不是重写方法，是为了使业务逻辑更清晰，而独立写的方法*/
	/** 敌机+蜜蜂 */
	public void paintFlyingObject(Graphics g) { /** Graphics画笔类，用于画对象 */
		for(int i=0;i<flyings.length;i++){
			FlyingObject f = flyings[i];
			g.drawImage(f.image, f.x, f.y, null);
		}
	}
	/** 英雄机 */
	public void paintHero(Graphics g) {
		g.drawImage(hero.image, hero.x, hero.y, null);
	}
	/** 子弹 */
	public void paintBullet(Graphics g) {
		for(int i=0;i<bullets.length;i++){
			Bullet b = bullets[i];
			g.drawImage(b.image, b.x, b.y, null);
		}
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Fly"); /** 设置游戏显示的框架，相当于相册的相框，并把标题设置为Fly*/
		ShootGame game = new ShootGame(); /** 实例化ShootGame类 */
		frame.add(game); /** ShootGame继承了Jpanel面板类，这里是把面板Jpanel加到JFrame*/
		
		frame.setSize(WIDTH, HEIGHT); /** 设置JFrame大小*/
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); /** 设置点窗口的关闭后，同时关闭程序 */
		frame.setAlwaysOnTop(true); /** 始终前置JFrame窗口 */
		frame.setLocationRelativeTo(null); /** 把JFrame窗口居中 */
		frame.setVisible(true); /** 显示JFrame窗口，并通知系统尽快执行paint方法*/
	}

}
