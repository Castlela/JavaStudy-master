package day03_basic_运算符_分支结构if_switch;

import java.util.Scanner;

//任何复杂的逻辑都是通过三种结构来实现
//1)顺序结构:从上往下逐行执行，每句必走，没有判断或循环
//2)分支结构:有条件的执行语句，并非每句必走
//3)循环结构:
public class 分支结构_if_switch2 {

	public static void main(String[] args) {
//------------------------------------------------------------
//分支结构if
		int num = 6;
		if(num%2==0){
			System.out.println(num+"是偶数");
		}
		
//--------------------------------------------------
//分支结构if...else
		num = 5;
		if(num%2==0){
			System.out.println(num+"是偶数");
		}else{
			System.out.println(num+"是奇数");
		}
		
//用if做三个数的升序排序,以下三个if都必须执行，所以不能用if else
		int a=98,b=45,c=15;
		if(a>b){
			int t=a;
				a=b;
				b=t;
		}
		if(a>c){
			int t=a;
				a=c;
				c=t;
		}
		if(b>c){
			int t=b;
				b=c;
				c=t;
		}
		System.out.println("三个数的升序:"+a+" < "+b+" < "+c);

//--------------------------------------------------------------------------------
//分支结构if...else if...else
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入成绩:");
		int score = scan.nextInt();
		if(score>=0 && score<=100){
			if(score>=90){
				System.out.println("A-优秀");
			}else if(score>=80){
				System.out.println("B-良好");
			}else if(score>=60){
				System.out.println("C-中等");
			}else{
				System.out.println("A-不及格");
			}
		}else{
			System.out.println("输入有误！");
		}
		
//以上判断可以优化为以下：
		if(score<0 || score>100){
			System.out.println("不合法！");
		}else if(score>=90){
			System.out.println("A-优秀");
		}else if(score>=80){
			System.out.println("B-良好");
		}else if(score>=60){
			System.out.println("C-中等");
		}else{
			System.out.println("A-不及格");
		}
		//System.out.println("在判断以外，每次都执行！");
//------------------------------------------------------------------------------------		
//switch,注意选项是数字，相等,并且要和break结合。
//这里，如果没有break的话，匹配中选项后，还会继续往下执行。
		System.out.println("请输入你要查询的业务:");
		System.out.println("1.话费查询\n2.办理业务\n3.人工服务");
		int num2 = scan.nextInt();
		switch(num2){ //byte,short,int,char 可选类型
		default:
			System.out.println("你的输入有误");
			break;
		case 1:
			System.out.println("话费查询");
			break;
		case 2:
			System.out.println("办理业务");
			break;
		case 3:
		case 4:
		case 5:
			System.out.println("人工服务"); //选择 3、4、5 都会跳到人工服务。
			break;
		}
			
	}
	
}
