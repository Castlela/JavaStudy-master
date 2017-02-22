package day12.oop_多态_内部类_面向对象总结_调试Debug;
//演示成员内部类（成员内部类、匿名内部类），内部类也会生成.class文件
public class innerClassDemo {	
	public static void main(String[] args) {
		Mother m = new Mother();
		//Baby b = new Baby(); //1、编译错误，内部类对外不具备可见性
	}	
}
//成员内部类（不常用）-----------------------------------------------
class Mother{ //外部类
	private String name; //定义Mother的私有属性
	public Baby createBaby(){ //2、外部类可创建内部类对象
		return new Baby();
	}
	
	class Baby{//成员内部类，可以访问外部类的属性
		private int a;
		public void showMotherName(){
			System.out.println(name);//3、这里等价于Mother.this.name
			System.out.println(Mother.this.name); 
			//System.out.println(this.name); //4、编译错误，本类中没有name属性
			
		}
	}
}

//-------------------------------------------------
