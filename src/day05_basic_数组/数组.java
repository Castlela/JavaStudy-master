package day05_basic_数组;

import java.util.Arrays;

public class 数组 {
//数组是有自动初始化值的，int是0，double是0.0,boolean是false
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//1、数组定义
		//声明数组arry,包含10个元素，每个元素都是int型
		int[] arr = new int[4];
		
//2、数组的初始化
		int[] arry1 = new int[4]; //0,0,0,0
		int[] arry2 = {1,4,5,7};
		int[] arry3 = new int[]{1,4,5,7};
		int[] arry4;
		arry4 = new int[]{1,4,5,7};
		//arry4 = {1,4,5,7}; //编译错误；
		
//3.数组的访问
		int[] arry5 = new int[3];
		System.out.println("arry5数组的长度为:"+arry5.length);
		arry5[0] = 100;
		arry5[1] = 200;
		arry5[2] = 300;
		//arry5[3] = 400; //下标越界
		System.out.println("arry5["+(arry5.length-1)+"]="+arry5[arry5.length-1]); //输出最后一个元素
		
//4数组的遍历
		int[] arry6 = new int[10];
		for(int i=0;i<arry6.length;i++){ //循环赋值
			arry6[i] = (int)(Math.random()*100);
			System.out.println("arry6["+i+"]"+"="+arry6[i]);
		}
		
//求最大值
		int max = arry6[0];
		for(int i=1;i<arry6.length;i++){
			if(max<arry6[i]){
				max = arry6[i];
			}
		}
		System.out.println("max="+max);
		
//把最大值置于数组最后一个下标+1（用到以下数组复制的代码）
		/*arry6 = Arrays.copyOf(arry6, arry6.length+1);
		arry6[arry6.length-1] = max;
		for(int i=0;i<arry6.length;i++){ //循环赋值
			//arry6[i] = (int)(Math.random()*100);
			System.out.println("arry6["+i+"]"+"="+arry6[i]);
		}*/
		
//数组的复制 
		//方法一、System.arraycopy(源数组名，开始位置，目标数组名，开始位置，长度)
		int[] a = {10,20,30,40,50};
		int[] a1 = new int[6];
		System.arraycopy(a, 0, a1, 1, 4); //注意不要越界
		for(int j=0;j<a1.length;j++){
			System.out.println(a1[j]);
		}
		System.out.println();
		//数组复制
		//方法二 Arrays.copyOf 可以对数组进行扩容,数组的长度是固定的。所以只是把原数组指向一个新的内存空间
		int[] b = {10,20,30,40,50};
		//int[] b1 = Arrays.copyOf(b, 6); //{10,20,30,40,50,0}b的长度为5，复制到b1后，定义了数组长度为6，刚最后一位补0，
		int[] b1 = Arrays.copyOf(b, 4); //b
		
		b = Arrays.copyOf(b, b.length+1); //为源数组指向一个新的数组
		for(int j=0;j<b.length;j++){
			System.out.println(b[j]);
		}
		
//数组的排序 插入排序、冒泡排序、快速排序
		//1、使用系统自带方法
		int[] arr1 = {10,45,67,4,2,345,35};
		long y = System.currentTimeMillis();//开始计时
		Arrays.sort(arr1); //排序函数，升序;java没有提供降序方法
		long z = System.currentTimeMillis();//结束计时
		System.out.println("耗时："+(z-y));
		
		System.out.println("排序后：");
		for(int i=0;i<arr1.length;i++){
			System.out.println(arr1[i]);
		}
		
		//2、冒泡
		long start = System.currentTimeMillis();
		for(int i=0;i<arr1.length-1;i++){ //控制轮数，最后一个数，没必要和自己对比，所以这里是length-1
			for(int j=0;j<arr1.length-1-i;j++){//控制每轮次数
				if(arr1[j]>arr1[j+1]){ //每次都是和自己的下一个数做比较
					int temp = arr1[j];
					arr1[j] = arr1[j+1];
					arr1[j+1] = temp;
				}
			}
		}  
		long end = System.currentTimeMillis();
		System.out.println("打印冒泡排序结果：");
		for(int i=0;i<arr1.length;i++){
			System.out.println(arr1[i]+"时间：");
		}
		System.out.println("时间："+(end-start));
	}

}
