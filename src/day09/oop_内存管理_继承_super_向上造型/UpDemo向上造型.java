package day09.oop_内存管理_继承_super_向上造型;

public class UpDemo向上造型 {
	public static void main(String[] args) {
		Coo o1 = new Coo();
		o1.c = 1;
		o1.say();
		o1.d = 2; //编译错误，父类不能访问子类的属性
		
		Doo o2 = new Doo();
		o2.d = 1;
		o2.show();
		o2.c = 3; //子类能访问父类的属性和方法
		o2.say();
		
		Coo o3 = new Doo(); //能访问什么，点出来什么主要看引用类型
		o3.c = 1;
		o3.say();
		o3.d = 2; //编译错误，父类不能访问子类的属性
	}
}

class Coo{
	int c;
	void say(){}
}

class Doo extends Coo{
	int d;
	void show(){};
}
