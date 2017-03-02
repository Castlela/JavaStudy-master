package 测试Shoot;

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
	public static BufferedImage airplane;
	public static BufferedImage bee;
	public static BufferedImage bullet;
	public static BufferedImage hero0;
	public static BufferedImage hero1;
	
	private Hero hero = new Hero();
	private FlyingObject[] flyings = {};
	private Bullet[] bullets = {};

	static{
		try{
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
	
	public void paint(Graphics g){
		g.drawImage(background, 0, 0, null);
		paintHero(g);
		paintFlyingObject(g);
		paintBullet(g);
	}
	public void paintHero(Graphics g){
		g.drawImage(hero.image, hero.x, hero.y, null);
	}
	public void paintFlyingObject(Graphics g){
		for(int i=0;i<flyings.length;i++){
			FlyingObject f = flyings[i];
			g.drawImage(f.image, f.x, f.y, null);
		}
	}
	public void paintBullet(Graphics g){
		for(int i=0;i<bullets.length;i++){
			Bullet b = bullets[i];
			g.drawImage(b.image, b.x, b.y, null);
		}
	}
	public FlyingObject nextOne(){
		Random rand = new Random();
		int type = rand.nextInt(20);
		if(type < 4){
			return new Bee();
		}else{
			return new Airplane();
		}
	}
	
	int airIndex = 0;
	public void airplane$BeeAction(){
		airIndex++;
		if(airIndex%40 == 0){
			FlyingObject f = nextOne();
			flyings = Arrays.copyOf(flyings, flyings.length+1);
			flyings[flyings.length-1] = f;
		}
	}
	public void stepAction(){
		hero.step();
		for(int i=0;i<flyings.length;i++){
			flyings[i].step();
		}
		for(int i=0;i<bullets.length;i++){
			bullets[i].step();
		}
	}
	int shootIndex = 0;
	public void bulletAction(){
		shootIndex++;
		if(shootIndex%30 == 0){
			Bullet[] bs = hero.shoot();
			bullets = Arrays.copyOf(bullets, bullets.length+bs.length);
			System.arraycopy(bs, 0, bullets, bullets.length-bs.length, bs.length);
		}
	}
	public void outSideBoundAction() {
		int outIndex = 0;
		FlyingObject[] flyingLives = new FlyingObject[flyings.length];
		for (int i = 0; i < flyings.length; i++) {
			FlyingObject f = flyings[i];
			if (!f.outSideBound()) {
				flyingLives[outIndex] = f;
				outIndex++;
			}
		}
		System.out.println("前：---->"+flyings.length);
		flyings = Arrays.copyOf(flyingLives, outIndex);
		System.out.println("后：++++>"+flyings.length);
		
		outIndex = 0;
		Bullet[] bs = new Bullet[bullets.length];
		for (int i = 0; i < bullets.length; i++) {
			Bullet b = bullets[i];
			if (!b.outSideBound()) {
				bs[outIndex] = b;
				outIndex++;
			}
		}
		bullets = Arrays.copyOf(bs, outIndex);
	
		
	}
	public void action(int intervel){
		MouseAdapter l = new MouseAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				hero.moveTo(x, y);
			}
		};
		this.addMouseListener(l);
		this.addMouseMotionListener(l);
		Timer timer = new Timer();
		timer.schedule(new TimerTask(){
			public void run(){
				outSideBoundAction();
				airplane$BeeAction();
				stepAction();
				bulletAction();
				repaint();
			}
		}, intervel,intervel);
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Flying");
		ShootGame game = new ShootGame();
		frame.add(game);
		frame.setSize(WIDTH, HEIGHT);
		frame.setLocationRelativeTo(null);
		frame.setAlwaysOnTop(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		game.action(10);
	}

}
