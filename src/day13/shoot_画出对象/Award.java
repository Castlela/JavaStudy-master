package day13.shoot_画出对象;
/** 奖励 */
public interface Award {
	public static final int DOUBLE_FIRE = 0; //火力值 
	public static final int LIFE = 1; //命
	/** 获得奖励类型 返回0为火力值 ，返回1是命*/
	public int getType();
}
