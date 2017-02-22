package day10.oop_继承里的重写_重写重载区别_package和import_修饰符_static_final;
//static演示
public class StaticDemo {
	public static void main(String[] args) { //所以这里的main方法不会有隐式this,必须创建实例变量访问实例变量、方法
		Loo o1 = new Loo();
		o1.show(); //a=1,b=1
		
		System.out.println("============");
		Loo o2 = new Loo();
		o2.show(); //a=1,b=2
		
		System.out.println("============");
		Loo o3 = new Loo();
		o3.show(); //a=1,b=3
		
		System.out.println(Loo.b); //直接类名.静态变量 访问，建议，方便排查bug
		System.out.println(o3.b);  //也可以用 对象.静态变量 访问 ，但不建议，因为不易发现是静态变量
		
		Moo.test();//静态方法通过类名.来访问
		System.out.println(Moo.b);//2
		
		Noo o4 = new Noo(); //运行结果：静态块、构造方法
		Noo o5 = new Noo(); //运行结果：构造方法
	}
}

class Noo{//静态块，一般用于加载音频、地图、图片、视频
	static{ //只会运行一次，加载类时
		System.out.println("静态块");
	}
	
	Noo(){//多少个无参实例变量，就运行多少次
		System.out.println("构造方法");
	}
}

class Moo{
	int a;
	static int b;
	void show(){
		a = 1;
		b = 2;
	}
	static void test(){ //静态方法没有隐式this
		//a = 1; //没有this，就意味没有对象访问该实例属性，所以这里编译错误
		b = 2;
		//show();//没有this，就意味没有对象访问该实例方法，所以这里编译错误
	}
}

class Loo{
	int a; 		  //实例变量,被存于堆内存中，成员变量都有默认值，这里是0
	static int b; //静态变量，被存于方法区中，只有一份，所有对象数据都一样时使用

	Loo(){
		a++;
		b++;
	}

	void show(){
		System.out.println("a="+a);
		System.out.println("b="+b);
	}
	
	
	
}
