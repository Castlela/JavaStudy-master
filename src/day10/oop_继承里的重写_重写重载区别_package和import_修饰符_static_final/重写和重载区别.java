package day10.oop_继承里的重写_重写重载区别_package和import_修饰符_static_final;
//什么是重写？重载和重写的区别：
public class 重写和重载区别 {
	//能点出什么，要看引用的类型
	//调用哪个方法，要看new的对象
	
	/*重写要遵循“两同两小一大”原则
	 *1、两同：
	 *	1）方法名称相同
	 *	2）参数列表相同 
	 *2、两小：
	 *	1）子类的返回值 类型<=父类
	 *		1.1）void和基本类型时，必须相同
	 *		1.2）引用类型时，小于或等于
	 *	2）子类方法抛出异常<=父类 -- 异常
	 *3、一大：
	 *	1）子类方法的访问权限>=父类 -- 访问修饰符
	 */
	
	/*重载和重写的区别：
	 * 重载：一个类中，方法名相同，参数列表不同，方法体不同，重载看引用
	 * 		遵循“编译期”绑定，根据引用类型绑定
	 * 重写：父子类中，方法名相同，参数列表相同，方法体不同，重写看对象
	 * 		遵循“运行期”绑定，根据对象类型调用
	 */
	
	public static void main(String[] args) {
		/*Aoo a = new Aoo(); //父类show 主要看new Aoo(),这里是Aoo,就是调用Aoo里的show
		a.show();
		
		Boo b = new Boo(); //子类show
		b.show();
		
		Aoo ab = new Boo();//子类show
		ab.show();*/
		
		Goo goo = new Goo();
		Eoo o = new Foo(); 
		goo.test(o); //这里先根据引用是Eoo,进入Eoo为参数的test方法，当o需要调用时，识别到是用Foo去new的，所以调用的是Foo里的show
		
		
	}
}

class Aoo{
	void show(){
		System.out.println("父类show");
	}
}

class Boo extends Aoo{
	void show(){
		super.show();//调用父类中的show方法
		System.out.println("子类show");
	}
}	
//两小例子
//在java中父类大，子类小
class Coo{
	void sayHi(){}
	double show(){return 0.0;}
	Coo test(){return null;}
	Doo say(){return null;}
}

//两小例子 
class Doo extends Coo{
	void sayHi(){} //void时必须相同
	double show(){return 1;} //基本类型时也必须相同
	Doo test(){return null;} //小于父类
	//Coo say(){return null;} //这里重写大于父类了 Coo>Doo
}

//重载demo
class Goo{
	void test(Eoo o){
		System.out.println("父型参数");
		o.show();
	}
	void test(Foo o){
		System.out.println("子型参数");
		o.show();
	}
}
//重写demo
class Eoo{
	void show(){
		System.out.println("父类show");
	}
}
//重写demo
class Foo extends Eoo{
	@Override
	void show() {
		System.out.println("子类show");
	}
}


