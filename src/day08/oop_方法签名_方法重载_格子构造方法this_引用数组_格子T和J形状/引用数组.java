package day08.oop_方法签名_方法重载_格子构造方法this_引用数组_格子T和J形状;

public class 引用数组 {

	public static void main(String[] args) {
//1、引用数组赋值 方法1
		/*Cell[] cells = new Cell[4]; //创建Cell数组对象
		cells[0] = new Cell(2,5); //创建对象
		cells[1] = new Cell(3,6);
		cells[2] = new Cell(4,7);
		cells[3] = new Cell(5,8);*/
		
//2、引用数组赋值 方法2 (注意以下的Cell[]里不能写数，否则报错例如Cell[4])
	/*	Cell[] cells = new Cell[]{
				new Cell(2,5), //创建对象
				new Cell(3,6),
				new Cell(4,7),
				new Cell(5,8)
		};*/

//3、数组的数组（Java里没有绝对的二维数组，一般C语言等语言才叫二维数组）
		/*int[][] arr = new int[3][]; //声明一个具体3个数组的数组
		arr[0] = new int[2]; //给每个数组赋值，注意这里arr[0]的默认值是null
		arr[1] = new int[3];
		arr[2] = new int[2];
		arr[1][0] = 100; //给数组的数组赋值*/

//4、矩型数组
		/*int[][] arr = new int[3][4];//3行4列
		for(int i=0;i<arr.length;i++){ //arr数组的长度
			for(int j=0;j<arr[i].length;j++){ //arr数组的数组的长度
				arr[i][j] = 100; //把所有值赋值为100
			}
		}*/
		
	}

}
