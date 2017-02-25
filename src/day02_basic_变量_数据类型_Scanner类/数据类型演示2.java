//数据类型：byte->short->int->long->float->double
/*
 * 注意:1、整型 4个字节，1字节=8bit，4*8=32bit 俗称32位，int的范围是正负21亿左右，超最大值会溢出
 * 	   2、byte,short,char运算时一律先转为int，再运算。
 * 	   3、byte c7 = (byte)(a7 + b7); //a7、b7为byte变量时运算会自动转为int，所以要强转
 * 	   4、舍入误差: 3.0-2.9 = 0.10000000000000009
 */
package day02_basic_变量_数据类型_Scanner类;
public class 数据类型演示2 {

	public static void main(String[] args) {
//int 
//********************************************************************
		//整型 4个字节，1字节=8bit，4*8=32bit 俗称32位，int的范围是正负21亿左右
		int a = 250; //250为整数的直接量，默认为int类型。
		//int b = 10000000000; //超出了范围
		
		System.out.println(5/2); //2 小数被舍去了
		System.out.println(2/5); //0 小数被舍去了
		
		int c = 2147483647; //int 的最大值
		c = c + 1; //最大值 + 1
		System.out.println(c); //-2147483648 溢出，回滚到int的最小值

//long 长整型，8个字节，8*8=64bit
//********************************************************************
		long a2 = 250L; //250 为long的直接量
		
		//long b2 = 10000000000; //100亿 没有在数字尾部加L，便默认为int的直接量
		long c2 = 10000000000L;//正确
		
		long d2 = 1000000000 * 2 * 10L; //20000000000正常，在没溢出前转换为long
		System.out.println(d2);
		
		long e2 = 1000000000 * 3 * 10L; //-12949672960 溢出,1000000000*3默认int类型超过21溢出
		System.out.println(e2);
		
		long f2 = 1000000000L * 3 * 10; //30000000000正常，在没溢出前转换为long
		System.out.println(f2);
		
		long g = System.currentTimeMillis(); //获取1970-1-1 至今的毫秒数
		System.out.println(g);
	
//long 浮点型，8个字节，8*8=64bit
//********************************************************************
		double a3 = 3.14159; //3.14159为浮点数的直接量，默认为double型
		float b3 = 3.14159F; //3.14159F默认为float的直接量
		
		double c3 = 3.0;
		double d3 = 2.9;
		System.out.println("舍入误差"+(c3-d3)); //舍入误差
		
//boolean 布尔型，1个字节，值只能是true或false
//********************************************************************
		boolean a4 = true;
		boolean b4 = false;
		
		//boolean c4 = 250; //错误，不只能是true或false
	
//char 字符型，2个字节
//********************************************************************
		char a5 = '男';
		char b5 = 'm';
		char c5 = ' ';
		//char d5 = ''; //错误，单引号里必须有东西
		//char e5 = 女; //错误，必须要有单引号
		//char f5 = '男性'; //必须是单个字符
		//char g5 = 97000; //范围必须是65535范围内，2字节*8bit=16bit,1111111111111111 = 65535
		char h5 = 97;
		System.out.println(h5); //a 因为h5定义的是字符型
		
		System.out.println(2+2);//4
		System.out.println('2'+'2');//100， '2'的码为50 ，50+50；byte,short,char运算时一律先转为int，再运算。而将int赋值byte必须强转
		
		//char i5 = '''; //单引号必须用转义符
		char j5 = '\''; // char j5 = '\\';
		System.out.println(j5);
		
//类型间的转换 byte->short->int->long->float->double
//		         ->char->
//=====================================================================
		int a6 = 5;
		long b6 = a6; //小转大，自动转换
		int c6 = (int)b6; //大转小，要强转
		
		long d6 = 5; //int的直接量，小转大，自动转
		double e6 = 5;//int的直接量，小转大，自动转
		System.out.println(e6);
		
		long f6 = 10000000000L; //100亿
		int g6 = (int)f6; // 用超出int范围的数，强转为int,会出现溢出。
		System.out.println(g6);//1410065408
		
		double h6 =25.96;
		int i6 = (int)h6; //用浮点数转int，会出现精度丢失
		System.out.println("i6 = "+i6); //25
		
		byte a7 = 5; //范围是-128~127，int直接量可以直接赋值给byte,short,char,long
		byte b7 = 6;
		byte c7 = (byte)(a7 + b7);//错误，byte,short,char运算时一律先转为int，再运算。而将int赋值byte必须强转
		System.out.println(c7);
		
		
		
		
	}

}
