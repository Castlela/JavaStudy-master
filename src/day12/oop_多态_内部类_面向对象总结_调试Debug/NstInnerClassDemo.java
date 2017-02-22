package day12.oop_多态_内部类_面向对象总结_调试Debug;
//演示匿名内部类，常用（成员内部类、匿名内部类），内部类也会生成.class文件
public class NstInnerClassDemo {
	public static void main(String[] args) {		
		/* 1、创建Inter2的一个子类，没有名字
		 * 2、为该子类创建一个对象，引用 叫o1
		 * 3、{}中写子类的类体 */
		Inter2 o1 = new Inter2(){ //Inter2没有定义抽象方法，所以没要求重写	
		}; 
		
		final int num = 5;
		/* 1、创建Inter2的一个子类，没有名字
		 * 2、为该子类创建一个对象，引用 叫o1
		 * 3、{}中写子类的类体 */
		Inter3 o3 = new Inter3(){ //Inter3定义了抽象方法，必须重写
			public void show(){
				System.out.println("匿名内部类的 show method");
				//在匿名内部类中访问外部数据，该数据必须是final的
				System.out.println("在main方法中定义的num="+num);
			}
		};
		o3.show(); //调用匿名内部类中的show方法
	}
}

interface Inter3{
	public abstract void show();
}

interface Inter2{}


