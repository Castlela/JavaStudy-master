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

package day15.shoot3_开打;
import java.awt.Color;
import java.awt.Font;
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
	
	public static final int START = 0;
	public static final int RUNNING = 1;
	public static final int PAUSE = 2;
	public static final int GAME_OVER = 3;
	private int state = START;
	
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
			//System.out.println("enterAction-->"+"flyings="+flyings.length);
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
	
	public void bangAction(){
		for(int i=0;i<bullets.length;i++){
			Bullet b  = bullets[i];
			bang(b);
		}
	}
	
	int score = 0;
	public void bang(Bullet b){
		//System.out.println(score);
		int bangIndex = -1;
		for(int i=0;i<flyings.length;i++){
			FlyingObject f = flyings[i];
			if(f.shootBy(b)){
				bangIndex = i;
				break;
			}
		}
		if(bangIndex!=-1){
			FlyingObject one = flyings[bangIndex];
			if(one instanceof Enemy){
				Enemy e = (Enemy)one;
				score+=e.getScore();
				
			}else if(one instanceof Award){
				Award a = (Award)one;
				int type = a.getType();
				switch(type){
				case Award.DOUBLE_FIRE:
					hero.addDoubleFire();
					break;
				case Award.LIFE:
					hero.addLife();
					break;
				}
			}
			FlyingObject t = flyings[bangIndex];
			flyings[bangIndex] = flyings[flyings.length-1];
			flyings[flyings.length-1] = t;
			flyings = Arrays.copyOf(flyings, flyings.length-1);
			//one.x = 1000;
			//one.y = 1000;
		}
	}
	
	public void checkGameOverAction(){
		if(isGameOver()){
			state = GAME_OVER;
		}
	}
	
	public boolean isGameOver(){
		for(int i=0;i<flyings.length;i++){
			FlyingObject f = flyings[i];
			if(hero.hit(f)){
				hero.substractLife();
				hero.clearDoubleFire();
				FlyingObject t = flyings[i];
				flyings[i] = flyings[flyings.length-1];
				flyings[flyings.length-1] = t;
				flyings = Arrays.copyOf(flyings, flyings.length-1);
			}
		}
		return hero.getLife() <= 0;
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
		paintScoreAndLife(g);
		paintState(g);
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
	public void paintScoreAndLife(Graphics g) {
		g.setColor(new Color(0xFF0000));
		g.setFont(new Font(Font.SANS_SERIF,Font.BOLD,24));//字体、加粗、大小
		g.drawString("SCORE:"+score, 10, 25);
		g.drawString("Life:"+hero.getLife(), 10, 50);
		g.drawString("DoubleFire:"+hero.getDoubleFire(), 10, 75);
	}
	public void paintState(Graphics g) {
		switch(state){
		case START:
			g.drawImage(start,0,0,null);
			break;
		case PAUSE:
			g.drawImage(pause,0,0,null);
			break;
		case GAME_OVER:
			g.drawImage(gameover,0,0,null);
			break;
		}
	}
	
	public void action(){
		MouseAdapter l = new MouseAdapter(){
			@Override
			public void mouseMoved(MouseEvent e) {
				if (state == RUNNING) {
					int x = e.getX();
					int y = e.getY();
					hero.moveTo(x, y);
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(state == RUNNING){
					state = PAUSE;
				}
			}
			public void mouseEntered(MouseEvent e) {
				if(state == PAUSE){
					state = RUNNING;
				}
			}	
			@Override
			public void mouseClicked(MouseEvent e) {
				switch(state){
				case START:
					state = RUNNING;
					break;
				case GAME_OVER:
					score = 0;
					hero = new Hero();
					flyings = new FlyingObject[0];
					bullets = new Bullet[0];
					state = START;
					break;
				}
			}
			
		};
		this.addMouseListener(l);/** 处理鼠标操作事件*/
		this.addMouseMotionListener(l); /** 处理鼠标滑动事件*/
		
		int intervel = 10;
		Timer timer = new Timer();
		timer.schedule(new TimerTask(){

			@Override
			public void run() {
				if(state == RUNNING){
					enterAction();
					checkGameOverAction();
					shootAction();
					outOfBoundAction();
					bangAction();
					stepAction();
				}
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
