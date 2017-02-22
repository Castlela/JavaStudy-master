package day10.oop_演示访问修饰符;
import day10.oop_继承里的重写_重写重载区别_package和import_修饰符_static_final.Hoo;
//引用某包的所有类，不建议，因为速度慢
//import day10.oop_继承里的重写_重写重载区别_package和import_修饰符_static_final.*;

//演示访问控制修饰符2
public class Joo{ //演示同包
	void show(){
		Hoo o = new Hoo();
		o.a = 1; //public
		//o.b = 2; //编译错误，protected,不在同包，不是本类，o不是子类对象
		//o.c = 3; //编译错误，default,不是同包，不是本类
		//o.d = 4; //编译错误，private,不是本类
	}
}

class Koo extends Hoo{ //演示protected
	void show(){ //子类访问父类属性，不需要创建对象访问
		a = 1;
		b = 2;
		//c = 3; //编译错误，非同包，非本类
		//d = 4; //编译错误，非本类
	}
}
