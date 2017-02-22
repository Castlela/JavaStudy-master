package day07.oop_创建和调用类_对象_俄罗斯方块实例;

public class 创建学生对象 {
	 //学生类和创建学生对象，在同一个包中，所以不用import导入就能使用
	 	public static void main(String[] args) {
	 		//Castle在学习...
	 		//大家好，我叫Castle,今年27,家住广东肇庆！
	 		学生类 stu = new 学生类();
	 		stu.name = "Castle";
	 		stu.age = 27;
	 		stu.address = "广东肇庆！";
	 		stu.study();
	 		stu.sayHi();
	 		
	 		//Fish在学习...
	 		//大家好，我叫Fish,今年25,家住广东阳春！
	 		学生类 stu1 = new 学生类();
	 		stu1.name = "Fish"; 
	 		stu1.age = 25;
	 		stu1.address = "广东阳春！";
	 		stu1.study();
	 		stu1.sayHi();
	 		
	 		//null在学习...
	 		//大家好，我叫null,今年0,家住null
	 		学生类 stu2 = new 学生类();
	 		stu2.study(); 
	 		stu2.sayHi();
	 	}
	 
	 }
