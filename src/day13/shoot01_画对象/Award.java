/**
 * Award 奖励接口，bee扩展接口，为了以后增加bigbee时，准备。
*/
package day13.shoot01_画对象;
public interface Award {
	/** 奖励分两种情况：
	 * 1、DOUBLE_FIRE 双击火力值  用数字0代替。
	 * 2、LIFE 生命值 用数字1代替。
	 * */
	public int DOUBLE_FIRE = 0;
	public int LIFE = 1;
	
	/** 获得的奖励类型 */
	public int getType();
}
