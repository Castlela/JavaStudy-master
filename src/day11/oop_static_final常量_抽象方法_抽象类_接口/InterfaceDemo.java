package day11.oop_static_final常量_抽象方法_抽象类_接口;
public class InterfaceDemo {
	public static void main(String[] args) {
		//Inter5 o1 = new Inter5(); //编译错误，接口不能实例化
		Inter6 o2 = new Foo(); //向上造型
		Inter5 o3 = new Foo();//向上造型
	}
}

//接口可以继承接口---------------------------------
interface Inter5{
	void show();
}
interface Inter6 extends Inter5{ //接口间的继承
	void say();
}
class Foo implements Inter6{
	public void show(){}
	public void say(){}
}

//先继承，后实现，只能继承一个类，实现无数个接口------------
interface Inter3{
	void show();
}

interface Inter4{
	void say();
}
abstract class Doo{
	abstract void test();
}
class Eoo extends Doo implements Inter3,Inter4{
	public void show(){}
	//void show(){} //这样写会报错，报错原因是接口方法默认的访问权限是public，这里没有写public则使用了默认，默认比public范围小
	public void say(){}
	void test(){}
}

//演示接口的实现------------------------------
interface Inter2{
	void show();
	void say();
}
class Coo implements Inter2{
	public void show(){} //实现接口后，必须重写接口里的所有方法
	public void say(){}
}

//演示接口基础语法--------------------------------
interface Inter1{
	public static final double PI = 3.14159;//常量
	public abstract void show(); //抽象方法
	
	int NUM = 250; //系统默认加上public static final
	void say(); //系统默认加上public abstract
	
	//int count; //编译错误，常量必须声明同时初始化
	//void sayHi(){} //编译错误，接口中只有没有方法体的抽象方法
}
