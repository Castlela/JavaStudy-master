//右键项目，Export-->java-->javadoc
//乱码解决，在生成javadoc前，输入javadoc -encoding UTF-8 -charset UTF-8
package day16.SE_API_String;
/**
 * 文档注释 </br>
 * 1、文档注释可以对类、方法、常量进行修饰 </br>
 * 2、文档注释可以被javadoc命令所解释，然后生成一个文档手册,
 * 当前类是用来测试文档注释的使用规范。
 * @author Castle (作者)
 * @version 1.0 04/03/17 (版本)
 * @see java.lang.String (参考类)
 * @since JDK1.0(最低运行环境)
 */
public class APIDocDemo文档注释 {
	/**
	 * sayHello(String name)方法中用到的问候语
	 */
	public static final String INFO = "您好！";
	
	/**
	 * 为制定的用户添加一个问候语。
	 * @param name 指定的用户的名字
	 * @param xxx 
	 * @return 添加问候语后的字符串。
	 */
	public static String sayHello(String name){
		return INFO+name;
	}
}
