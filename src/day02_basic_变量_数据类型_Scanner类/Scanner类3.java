package day02_basic_变量_数据类型_Scanner类;

import java.util.Scanner; //第一步，导入Scanner类>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

public class Scanner类3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in); //第二步，创建Scanner对象>>>>>>>>>>>>>>>>>>
		System.out.println("please enter your age:");
		int age = scan.nextInt(); //第三步，接收int类型的数据>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		System.out.println(age);
		
		System.out.println("please enter your salary:");
		double salary = scan.nextDouble();
		System.out.println(salary);
		
		
	}

}
