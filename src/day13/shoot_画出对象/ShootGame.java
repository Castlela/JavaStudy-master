package day13.shoot_画出对象;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
/** 主程序类 */
public class ShootGame extends JPanel{
	public static final int WIDTH = 400;
	public static final int HEIGHT = 654;
	
	public static BufferedImage background;
	public static BufferedImage start;
	public static BufferedImage pause;
	public static BufferedImage gameover;
	public static BufferedImage airplane0;
	public static BufferedImage bee0;
	public static BufferedImage bullet;
	public static BufferedImage hero0;
	public static BufferedImage hero1;
	
	private Hero hero = new Hero();
	private Bullet[] bullets = {};
	private FlyObject[] flyings = {}; //把此类当作敌机+小蜜蜂
	
	public ShootGame() {
		flyings = new FlyObject[2];
	}
	
	static{
		try{//IO流都用try catch
			background = ImageIO.read(ShootGame.class.getResource("background.png"));
			     start = ImageIO.read(ShootGame.class.getResource("start.png"));
			     pause = ImageIO.read(ShootGame.class.getResource("pause.png"));
			  gameover = ImageIO.read(ShootGame.class.getResource("gameover.png"));
			 airplane0 = ImageIO.read(ShootGame.class.getResource("airplane0.png"));
			      bee0 = ImageIO.read(ShootGame.class.getResource("bee0.png"));
			    bullet = ImageIO.read(ShootGame.class.getResource("bullet.png"));
			     hero0 = ImageIO.read(ShootGame.class.getResource("hero0.png"));
			     hero1 = ImageIO.read(ShootGame.class.getResource("hero1.png"));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Fly"); //创建一个窗口
		ShootGame game = new ShootGame();
		frame.add(game); //把当前对象（面板）加入窗口
		
		frame.setSize(WIDTH, HEIGHT); //设置窗口的大小
		frame.setAlwaysOnTop(true); //将窗口顶置
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置默认关闭操作（关闭窗口，退出程序）
		frame.setLocationRelativeTo(null);//设置窗口剧中显示 
		frame.setVisible(true); //设置窗口可见
	}

}
