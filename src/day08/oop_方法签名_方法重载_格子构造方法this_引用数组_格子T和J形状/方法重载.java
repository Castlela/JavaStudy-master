package day08.oop_方法签名_方法重载_格子构造方法this_引用数组_格子T和J形状;
/*
 * 补充：
 * 1、在同一个文件中可以包含多个类
 * 2、public修饰类只能有一个
 * 3、public修饰的类必须与文件名相同
 * 4、方法签名:方法名+方法参数
 */
public class 方法重载 {
	public static void main(String[] args) {
		Aoo a = new Aoo();
		a.sayHi();
		a.sayHi(25);
		a.sayHi("Castle",28);
		a.sayHi(26,"Fish");
		//a.sayHi(8.88); 没有找以double为参数的方法
	}
}

/*public class Aoo{ //public在一个文件中只能修饰一个类
}*/

//方法的重载（同一个类中，方法名相同，参数不同称为重载）
class Aoo{
	void sayHi(){} //1
	void sayHi(String name){}
	void sayHi(int age){}
	void sayHi(String name,int age){}
	void sayHi(int age,String name){}
	
	//int sayHi(){return 1} //与1的方法签名一致，与返回值无关，所以报错
	//void sayHi(String address){} //与参数名字无关
	
}
