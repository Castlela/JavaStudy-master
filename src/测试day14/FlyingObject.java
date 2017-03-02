/** 
 * 抽象类，抽取所有飞行对象的共有属性和方法 
 */
package 测试day14;
import java.awt.image.BufferedImage;/** BufferedImage读取图片类*/
public abstract class FlyingObject {
	/**注意：
	 * 抽象类的属性，要被子类所访问，此处用protected
	 * 把子类共有的属性抽出来，减少重复代码。
	 * 当满足既是...又是...时，一般先考虑用抽像类+接口的形式
	 */
	protected BufferedImage image; /** 图象 */
	protected int x;	 /** 图像原点的x坐标 */
	protected int y;	 /** 图像原点的y坐标 */
	protected int width; /** 图像的宽*/
	protected int height;/** 图像的高*/
	
	public abstract void step();
}
