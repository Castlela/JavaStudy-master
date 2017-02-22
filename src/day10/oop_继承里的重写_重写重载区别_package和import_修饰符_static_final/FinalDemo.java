package day10.oop_继承里的重写_重写重载区别_package和import_修饰符_static_final;

public class FinalDemo {

	public static void main(String[] args) {
		
	}

}
//演示final修饰类，String、Math、Double、Integer都是final类，防止滥用继承
final class Roo{} //final的类，能继承别的类
//class Soo extends Roo{} //编译错误，final的类不能被继承 

//-----------------------------------------------------------
class Poo{//演示final修饰方法，防止子类在定义新的方法时造成“不经意”重写
	final void show(){}
	void test(){}
}

class Qoo extends Poo{//演示final修饰方法
	//void show(){} //编译错误，final的方法不能被重写
	void test(){} 
}
//-------------------------------------------------------
/*
 * final修饰成员变量，两种方式初始化：
 *   1）声明的同时初始化
 *   2）构造方法中初始化
 * final修饰局部变量，只要在用之前初始化即可
 */
class Ooo{//演示final修饰变量
	final int a = 5; //声明同时初始化
	final int b;
	Ooo(){
		b = 4;
	}
	
	void show(){
		final int c;//用之前赋值即可，不用可以不赋值 。
		//a = 8; //编译错误，final的变量的值不能改变
	}
}
