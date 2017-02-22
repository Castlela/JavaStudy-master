package day09.oop_内存管理_继承_super_向上造型;

public class SuperDemo {

	public static void main(String[] args) {
		Boo b = new Boo();
		//System.out.println(b.a); //5 这里可以直接访问成员变量
	}
}

class Aoo{
	//加上以下这段代码，Boo将不会报错
	//Aoo(){}
	int a;
	Aoo(int a){
		this.a = a;
	}
}

class Boo extends Aoo{  //这里报错的原因是由于以下
	//系统会默认生成以下这段代码，但由于Aoo已写了有参构造，不自动生成无参构造 ，所以会错，也就是调用了不存在的方法
	Boo(){
		super(); //super(5); //这里直接调用父类带参构造，也不会报错
	}
}