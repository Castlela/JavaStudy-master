//运算符例子
/*
 * 1、算术运算符 + - * / % ++ --
 * 2、关系运算符 > < >= <= == != 
 * 3、逻辑运算符 && || & |
 * 4、赋值运算符 =
 * 5、三目运算符    boolean条件?数1:数2
 * 
 * 注意:1、单独使用，++a 与 a++ 是一样的
 *     2、在被使用时,自增,自减 b=++a和b=a++是不一样的
 *      
 */
package day03_basic_运算符_分支结构if_switch;
import java.util.Scanner;

public class 运算符1 {

	public static void main(String[] args) {
//1、算术运算符 +,-,*,/,%,++,--
		
		//求%余
		System.out.println(8%2); //0
		System.out.println(2%8); //2
		System.out.println(8.456%2); //0.4559999999999995 舍入误差，特殊例子。
//----------------------------------------------------------------------------		
		//单独使用,自增,自减 ++,-- 
		int a=5,b=5;
		a++; //单独使用，++a 与 a++ 是一样的
		++b;
		System.out.println(a); //6
		System.out.println(b); //6 
		
		//在被使用时,自增,自减 ++,-- 
		int a1=5,b1=5;
		int c1 = a1++; //单独使用，++a 与 a++ 是一样的
		int d1 = ++b1;
		System.out.println(a1); //6
		System.out.println(b1); //6 
		System.out.println(c1); //5 a1++
		System.out.println(d1); //6 ++b1
// ---------------------------------------------------------------------------------------------------
//2、关系运算符 >,<,>=,<=,==,!= ,成立则true,不成立则false
		int a2=5,b2=10,c2=5;
		boolean bool = a2 > b2;
		System.out.println(bool); //false
		System.out.println(c2<b2); //true
		System.out.println(a2>=c2);//true
		System.out.println(a2==c2);//true
		
//----------------------------------------------------------------------------------------------
//3、逻辑运算符 &&逻辑与(两边条件都为true才为true)、||逻辑或(两边条件只要一方为true者为true))、！逻辑非 ，结果也是true或false
//多个条件判断时，必须是 关系运算符+算述运算符一起用
//例如 数学>=60 && 语文>=60，短路，一边为假就不执行了
		int a3=5,b3=10,c3=5;
		boolean bool2 = a3>b3 && c3<=b3; //false && true = false
		System.out.println(bool2);
		System.out.println(a3==c3 && b3<c3);//true && false = false
		
//逻辑或|| 短路，一边为真就不执行了
		System.out.println(a3>b3 || c3<=b3);//false && true = true
		
//逻辑非！
		System.out.println(!(a3>c3)); //!(5>5)
		
//测试逻辑短路
		int a4=1,b4=2,c4=3;
		boolean bool3 = a4>b4 && a4++>2; //a4>b4为false，所以后面的a4++就没执行了，于是a4仍然是1
		System.out.println(bool3);
		System.out.println(a4);
		
// &&与&、||与|区别在于双个符号就是短路，单个符号就不短路，一般短路的才是常用。
		 
//--------------------------------------------------------------------------------------
//赋值运算符
		//普通赋值=
		int a5=18,b5;
		System.out.println(b5=a5/3);
		System.out.println(b5); //6
		
		int a6,b6,c6;
		a6=b6=c6=10;
		System.out.println(a6);
		
		//扩展运算符+=，-=，*=，／=，%=
		int a7=5;
		a7+=10; //a7=a7+10;
		System.out.println(a7); 
		
//面试题
		short s1=5; //5是int直接量，可以直接给short赋值
		//s1=s1+10; //两个int类型相加得出一个int数，而并非int直接数，这里需要强转 s1=(byte)(s1+10)
		s1+=10; //正确，扩展赋值自动帮忙强转了
		
//字符串拼接+
//若两边为数字，则做加法运算
//若有一边为字符串，则做字符串拼接
		int age = 37;
		
		System.out.print("age=");//age=
		System.out.println(age);//37
		//----------------------------------
		System.out.println("age="+age); //相当于以上两句一起输出的结果
		System.out.println("我的年龄是:"+age);
		
		System.out.println(10+20+""+30); //字符串前面还是正常运算 3030
		System.out.println(10+20+30+""); //60
		System.out.println(""+10+20+30); //102030
		
//6、三目运算符，连接三个数，所以叫三目运算符
//boolean?数1:数2
		int a8=56,b8=8;
		int max = a8>b8?a8:b8;
		System.out.println("max="+max);
		
//三目运算符嵌套 ,注意嵌套越多，可读性越性，不建议
		int a9 = -3;
		String r = a9>0?"正数":(a9==0?"0":"负数");
		System.out.println(r);

//结合学习的知识，判断输入年份是否闰年
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入要判断是否闰年的年份:");
		int year = scan.nextInt();
		boolean flag = (year%4==0 && year%100!=0) || year%400==0;
		String str = flag?year+"是闰年":year+"不是闰年";
		System.out.println(str);
		
	}

}
