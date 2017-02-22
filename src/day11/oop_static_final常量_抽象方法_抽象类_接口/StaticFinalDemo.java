package day11.oop_static_final常量_抽象方法_抽象类_接口;
//常量
public class StaticFinalDemo {

	public static void main(String[] args) {
		System.out.println(Aoo.PI);
		//Aoo.PI = 3.14; //编译错误，常量不能被改变
	
		/* 1.加载Boo.class到方法区中
		 * 2.count保存在方法区中
		 * 3.到方法区中获取count并输出*/
		System.out.println(Boo.count);
		
		/* 编译时自动替换为具体值，相当于System.out.println(5);效率更高
		 * 方便统一更改数据*/
		System.out.println(Boo.NUM);
	
	}
}

class Aoo{
	public static final double PI = 3.14159;
	//public static final double NUM; //编译错误，必须声明同时赋值
}

class Boo{
	public static final int NUM = 5; //常量，用全大写命名
	public final static int CLASS = 3; //final和static不分先后顺序，但一般用static final
	public static int count = 8; //静态变量，用起来一样，但值可改变
}
