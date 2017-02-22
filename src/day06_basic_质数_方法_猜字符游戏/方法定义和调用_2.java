package day06_basic_质数_方法_猜字符游戏;

public class 方法定义和调用_2 {
	//public static 修饰词
	//void 返回值 
	//main 方法名
	public static void main(String[] args) {
//方法的调用————————————————————————————————————————————————————————————————————————————
		say(); //调用无参无返回值方法
		
		sayHi("Fish"); //调用有参无返回值方法，注意参数类型和个数要匹配上
		
		double a = getNum();//有返回值，先定义变量获取返回值 
		System.out.println("3、无参有返回值getNum()-->"+a); //getNum的值 ，就是return回来的值 
		
		int c = plus(5,6);//有返回值，先定义变量获取返回值 
		System.out.println("4、有参有返回值plus(int a,int b)-->"+c);
		
		a(); //方法的调用
	}
	
//-------------------------------------------------------------------------------------
//方法的定义
	
	//1、无参无返回值 
	public static void say(){
		System.out.println("1、无参无返回值say()-->"+"Halo,I'm Castle.");
		//return;
	}
	//2、有参无返回值
	public static void sayHi(String name){
		System.out.println("2、有参无返回值sayHi(String name)-->"+"Halo,"+name+".");
		//return;
	}
	//3、无参有返回值
	public static double getNum(){
		return 8.88; //有返回值的，必须返回一个和返回值类型相同的值，结束方法的执行，并返回值给调用方
	}
	//4、有参有返回值 
	public static int plus(int a,int b){
		return a+b;
	}

//---------------------------------------------------------------------------
	//方法中能互相调用,例如银行取款，经常会用到查余额功能，这时存钱、取钱、转帐后都可以调用查余额
	public static void a(){
		System.out.println("a");
		b(); //在a()方法中调用b()方法
		System.out.println("over");
	}
	public static void b(){
		System.out.println("b");
	}

}
