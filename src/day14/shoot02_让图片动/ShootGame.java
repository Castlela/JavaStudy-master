/**
 * 1、先写ShootGame类准备游戏框架大小，游戏所用到的图片。
 * 2、在ShootGame写好游戏框架JFrame+面板JPanel,并setVisible();
 * 3、准备好抽象父类1个写step方法用于使图片动起来+接口2个
 * 4、新建4个类并继承父数、实现接口,写好各类新增属性、构造方法、重写方法。
 * 5、在ShootGame新增加Hero、Bullet[]、FlyingObejct[]向上造型(Airplane、Bee)
 * 6、新建nextOne方法，获得随机敌机/蜜蜂，返回FlyingObject
 * 7、创建enterAction方法，用于把随机创建的敌机/蜜蜂，加入FlyingObejct[]
 * 8、创建stpeAction方法，让Hero、Bullet[]、FlyingObejct[] 调用step方法。
 * 9、新建action方法，方法做定义Timer定时类，并写入TimeTask定时器，重写TimeTask的run方法，让其调用enterAction、stpeAction方法
 * 做ShootAction发射子弹，调用hero.shoot
 * 做鼠标事件，让Hero动起来
 * 做越界的删除
 * 10、在main中调用action方法
 */

package day14.shoot02_让图片动;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ShootGame extends JPanel{
	public static final int WIDTH = 400;
	public static final int HEIGHT = 654;
	
	public static BufferedImage background;
	public static BufferedImage start;
	public static BufferedImage pause;
	public static BufferedImage gameover;
	public static BufferedImage hero0;
	public static BufferedImage hero1;
	public static BufferedImage bullet;
	public static BufferedImage airplane;
	public static BufferedImage bee;
	
	public Hero hero = new Hero();
	public FlyingObject[] flyings = {};
	public Bullet[] bullets = {};
	
	public FlyingObject nextOne(){
		Random rand = new Random();
		int type = rand.nextInt(20);
		if(type < 4){
			return new Bee();
		}else{
			return new Airplane();
		}
	}
	
	int enterIndex = 0;
	public void enterAction(){
		enterIndex++;
		if(enterIndex%40 == 0){
			flyings = Arrays.copyOf(flyings, flyings.length+1);
			flyings[flyings.length-1] = nextOne();
			System.out.println("enterAction-->"+"flyings="+flyings.length);
		}
	}
	
	public void stepAction(){
		//System.out.println("stepAction-->"+"flyings="+flyings.length+" bullets="+bullets.length);
		hero.step();
		for(int i=0;i<flyings.length;i++){
			flyings[i].step();
		}
		for(int i=0;i<bullets.length;i++){
			bullets[i].step();
		}
	}
	
	int shootIndex = 0;
	public void shootAction(){
		//System.out.println("shootAction");
		shootIndex++;
		if(shootIndex%30==0){
			Bullet[] bs = hero.shoot();
			bullets = Arrays.copyOf(bullets,bullets.length+bs.length);
			System.arraycopy(bs, 0, bullets, bullets.length-bs.length, bs.length);
		}
	}
	
	public void outOfBoundAction(){
		//System.out.println("outOfBoundAction");
		int index = 0;
		FlyingObject[] flyingLives = new FlyingObject[flyings.length];
		for(int i=0;i<flyings.length;i++){
			FlyingObject f = flyings[i];	
			if(!f.outOfBounds()){
				flyingLives[index] = f;
				index++;
			}
		}
		flyings = Arrays.copyOf(flyingLives, index);
		
		index = 0;
		Bullet[] bulletLives = new Bullet[bullets.length];
		for(int i=0;i<bullets.length;i++){
			Bullet b = bullets[i];
			if(!b.outOfBounds()){
				bulletLives[index] = b;
				index++;
			}
		}
		bullets = Arrays.copyOf(bulletLives, index);
	}
	
	static {
		try {
			background = ImageIO.read(ShootGame.class.getResource("background.png"));
			start = ImageIO.read(ShootGame.class.getResource("start.png"));
			pause = ImageIO.read(ShootGame.class.getResource("pause.png"));
			gameover = ImageIO.read(ShootGame.class.getResource("gameover.png"));
			hero0 = ImageIO.read(ShootGame.class.getResource("hero0.png"));
			hero1 = ImageIO.read(ShootGame.class.getResource("hero1.png"));
			bullet = ImageIO.read(ShootGame.class.getResource("bullet.png"));
			airplane = ImageIO.read(ShootGame.class.getResource("airplane.png"));
			bee = ImageIO.read(ShootGame.class.getResource("bee.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void paint(Graphics g) {
		//System.out.println("--------------------------");
		g.drawImage(background, 0, 0, null);
		paintFlyingObject(g);
		paintBullet(g);
		paintHero(g);
	}
	public void paintFlyingObject(Graphics g) {
		for(int i=0;i<flyings.length;i++){
			FlyingObject flys = flyings[i];
			g.drawImage(flys.image,flys.x,flys.y,null);
		}
	}
	public void paintBullet(Graphics g) {
		for(int i=0;i<bullets.length;i++){
			Bullet b = bullets[i];
			g.drawImage(b.image,b.x,b.y,null);
		}
	}
	public void paintHero(Graphics g) {
		g.drawImage(hero.image, hero.x, hero.y, null);
	}
	
	public void action(){
		MouseAdapter l = new MouseAdapter(){
			@Override
			public void mouseMoved(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				hero.moveTo(x, y);
				
			}
		};
		this.addMouseListener(l);/** 处理鼠标操作事件*/
		this.addMouseMotionListener(l); /** 处理鼠标滑动事件*/
		
		int intervel = 10;
		Timer timer = new Timer();
		timer.schedule(new TimerTask(){

			@Override
			public void run() {
				enterAction();
				stepAction();
				shootAction();
				outOfBoundAction();
				repaint();
			}
			
		}, intervel,intervel);
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Fly");
		ShootGame game = new ShootGame();
		frame.add(game);
		
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setAlwaysOnTop(true);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		game.action();
	}

}
