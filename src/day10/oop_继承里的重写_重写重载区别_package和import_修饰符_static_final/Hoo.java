package day10.oop_继承里的重写_重写重载区别_package和import_修饰符_static_final;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;

//演示访问控制修饰符1
//建议数据（属性）私有化，行为（方法）公开化
public class Hoo {
	public int a;     //任何类
	protected int b;  //本类、子类、同包类
    int c;            //本类、同包类
	private int d;	  //本类
	
	void show(){
		a = 1;
		b = 2;
		c = 3;
		d = 4;
	}
}

class Ioo{
	void show(){ //演示private
		Hoo o = new Hoo();
		o.a = 1;
		o.b = 2;
		o.c = 3;
		//o.d = 4; //d是private定义，只能在本类中访问
	}
}
