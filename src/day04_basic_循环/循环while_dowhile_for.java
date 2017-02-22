package day04_basic_循环;

import java.util.Scanner;

public class 循环while_dowhile_for {

	public static void main(String[] args) {
//----------------------------------------------------------------------------------------------
//while 有可能一次都不执行 ,有当...的时候，用while
//输出10次-行动是成功的阶梯
		int times=0;
		while(times<10){
			times++;
			System.out.println("行动是成功的阶梯！"+times);
		}
		
//输出9的乘法表
		int i=1;
		while(i<=9){
			System.out.println(i+"*"+9+"="+i*9);
			i++;
		}
		System.out.println("=over=");
		
//猜数字
//		int num = 250;
//		System.out.println("猜数字:");
//		Scanner scan = new Scanner(System.in);
//		while(true){
//			int guess = scan.nextInt();
//			
//			if(num == guess){
//				System.out.println("猜对了");
//				break;
//			}else if(guess == 0){
//				System.out.println("投降了？下次再来！");
//				break;
//			}
//			
//			if(guess > num){
//				System.out.println("太大了！");
//				continue;
//			}else{
//				System.out.println("太小了！");
//				continue;
//			}
//			
//			
//		}
		
//猜数字
/*     	int num = (int)(Math.random()*1000+1); //生成1-1000内的随机数 
		Scanner scan = new Scanner(System.in);
		System.out.println("猜吧:");
		int guess = scan.nextInt();
		while(guess != num){ //循环条件！
			if(guess == 0){
				break;
			}
			if(guess > num){
				System.out.println("太大了！");
			}else{
				System.out.println("太小了！");
			}
			System.out.println("猜吧:");
			guess = scan.nextInt();
		}
		if(guess == num){
			System.out.println("猜对了！");
		}else{
			System.out.println("下次再猜！");
		}
*/
//--------------------------------------------------------------------------------------------------------
//do...while() 先执行再判断(至少要执行一次的循环，应该用do...while) 有直到...的时候，用do...while
		Scanner scan = new Scanner(System.in);
		int num = (int)(Math.random()*1000+1);
		//System.out.println(num);
		int guess;
		do{
			System.out.println("猜吧！");
			guess = scan.nextInt();
			if(guess == 0){
				break;
			}
			if(guess > num){
				System.out.println("太大了！");
			}else if(guess < num){
				System.out.println("太小了！");
			}
		}while(num != guess);
		if(num == guess){
			System.out.println("恭喜你，猜对了！");
		}else{
			System.out.println("下次再猜！");
		}

//------------------------------------------------------------------------------------------------------
//for循环 有固定次数循环的时候，应用率最高
		int sum = 0;
		for(int n=1;n<=100;n++){
			sum+=n;
		}
		System.out.println("sum="+sum);

//for循环的拆分
		int n1=1;
		for(;n1<=100;){
			n1++;
		}
		
//for的特殊用法
		for(int i1=1,j=6; i1<=6; i1+=2,j-=2){ //注意条件不能用,逗号隔开，多条件，可以考虑使用逻辑运算符
			System.out.println("test");
		}
		
//死循环
//		for(;;){
//			System.out.println("dea");
//		}
		
//系统随机出10题两位数的加数题。提示答对或答错，并算总分，每题10分。
		/*int s = 0;
		int k = 0;
		Scanner scann = new Scanner(System.in);
		for(int i3=1;i3<=10;i3++){
			int a = (int)(Math.random()*100);
			int b = (int)(Math.random()*100);
			System.out.print(a+"+"+b+"=");
			int hj = a + b;
			int scount = scann.nextInt();
			
			if(scount == -1){
				System.out.println("退出系统！");
			}
			if(hj == scount){
				System.out.println("对");
				k+=1;
			}else{
				System.out.println("错");
			}
			
		}
		System.out.println("总分："+10*k+"  错"+(10 -k)+"题")*/;
		
//同上题，答：
		Scanner scann = new Scanner(System.in); //系统输入
		int score = 0; //总分
		for (int k=1;k<=10;k++){
			int a = (int)(Math.random()*100);
			int b = (int)(Math.random()*100);
			int result = a + b;
			System.out.println("("+k+")"+a+"+"+b+"=");
			int input = scann.nextInt();
			if(input == -1){
				System.out.println("bye~see u...");
				break;
			}
			if(input == result){
				System.out.println("right!");
				score+=10;
			}else{
				System.out.println("wrong!");
			}
		}
		System.out.println("score="+score );
		
// 9+99+999+9999...+(10个9)
		long hj = 0; //总数
		long g = 0;
		for(int m=1;m<=10;m++){
			g = g*10+9;
			hj = hj + g;
		}
		System.out.println(hj);
		
//1+1/2+1/3...+1/n=?
		int n = 15;
		double sum4 = 0;
		//如果是 1 + 1／3 + 1／5 则以下的i++ 要改为 i0+2
		for(double i0=1;i0<=n;i0++){ //如果这里的double改为int
			sum4+=1/i0; //则 这里改为 1.0/i0 就可以了
		}
		System.out.println("sum="+sum4);
		
//嵌套循环99乘法表
		for(int u=1;u<=9;u++){ //控制行
			for(int v=1;v<=u;v++){ //控制列
				System.out.print(v+"*"+u+"="+u*v+"\t");
			}
			System.out.print("\n");
		}
		
	}  

}
