package day06_basic_质数_方法_猜字符游戏;

public class 质数_1 {

	public static void main(String[] args) {
		int count = 0;
		for(int num=2;num<=100;num++){
			boolean flag = true;
			//1、以下i<num 可改为 i<num/2
			//2、以下i<num 可改为 i<Math.sqrt(num)
			for(int i=2;i<num;i++){
				//注意，此处不能直接写else，因为是多次循环
				//此处用变量flag做标志，只要循环判断有一个是能整除1和本身以外的，就是false并跳出循环
				if(num%i==0){
					flag = false;
					break;
				}
			}
			
			if(flag){ //根据标记得出结论
				System.out.println(num +"是质数");
				count++;
				if(count%10 == 0){ //每10个空一行
					System.out.println();
				}
			}
		}
		
	}

}
