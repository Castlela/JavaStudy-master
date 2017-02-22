package day06_basic_质数_方法_猜字符游戏;

import java.util.Scanner;

//1、设计数据结构（数怎么存）
/*(1)char[] chs 随机生成字符数组
 *(2)char[] input 用户输入的数组
 *(3)int letterRight //字符对的个数
 *   int positionRight //位置对个数
 *   int[] result; //对比结果 
 *(4)int score 得分
 *(5)int count 猜错次数 
 */

//2、设计程序结构（方法）
/*
 * (1)主方法
 * 	  public static void main(String[] args){}
 * (2)随机生成字符数组
 *    public static char[] generate(){
 *      char[] chs = new char[5];
 *      return chs;
 *    }
 * (3)对比：随机数组和用户输入字符数组
 *    public static int[] check(char[] chs,char[] input){
 *    	int[] result = new int[2];
 *    	return result;
 *    }
 */

//3、设计算法（方法的实现）
public class 猜字符游戏_3 {
	//main主方法*******************************************************
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		char[] chs = generate(); //获取随机数组
		System.out.println(chs); //打印获取到的数组
		int count = 0; //计算错误次数
		
		while(true){
			System.out.println("开始猜字符游戏：");
			String str = scan.next().toUpperCase(); //输入字符串,并转换为大写
			if(str.equals("EXIT")){ //引用类型字符串判断， 不能用==
				System.out.println("下次再来！");
				break;
			}
			char[] input = str.toCharArray(); //把输入的字符串转换成char字符数组
			int[] result = check(chs,input); //对比字符数组
			if(result[0]==chs.length){ //位置对，就是全对
				int score = 100*chs.length-count*10; //猜错一次扣10分
				System.out.println("恭喜你猜对了！得分为："+score);
				break;
			}else{
				count++;
				System.out.println("正确字符:"+result[1]+" 正确位置"+result[0]);
			}
		}
	}
	
	//生成随机字符数组***************************************************
	public static char[] generate(){
		char[] chs = new char[5]; //定义随机字符数组变量
		char[] letters = {'A','B','C','D','E','F','G','H','I','J',
				          'K','L','M','N','O','P','Q','R','S','T',
				          'U','V','W','X','Y','Z'};
		boolean[] flags = new boolean[letters.length];
		/*for(int i=0;i<chs.length;i++){
			int index = (int)(Math.random()*letters.length);
			if(flags[index] == false){
				chs[i] = letters[index];
				flags[index] = true;
			}else{
				i--;
			}
		}*/
		for(int i=0;i<chs.length;i++){
			int index1;
			//如果随机数已出现过，则继续生成
			do{
				//生成0-25随机数以对应letters数组下标
				index1 = (int)(Math.random()*letters.length);
			}while(flags[index1]==true); //当index1=true时，则已生成过
			
			//能跳出上面循环，则未生成过，可以直接赋值
			chs[i] = letters[index1];
			//给当前字符下标标记为已生成过
			flags[index1] = true;
		}
		return chs;
	}
	
	//对比：随机字符数组-用户输入的字符数组***********************************
	public static int[] check(char[] chs,char[] input){
		int[] result = new int[2]; //记录位置对，字符对
		for(int i=0;i<chs.length;i++){ //遍历随机字符
			for(int j=0;j<input.length;j++){ //遍历用户输入符
				if(chs[i] == input[j]){//字符对+1
					result[1]++;
					if(i == j){ //位置对+1
						result[0]++;
					}
					break; //??00:48 相同字符，只记一次
				}
			}
		}
		return result;
	}

}
