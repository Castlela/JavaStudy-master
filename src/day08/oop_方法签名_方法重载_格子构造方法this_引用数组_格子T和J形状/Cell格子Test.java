package day08.oop_方法签名_方法重载_格子构造方法this_引用数组_格子T和J形状;
//构造方法、this关键字
public class Cell格子Test {
	public static void main(String[] args) {
		Cell格子 c = new Cell格子();
		c.setInfo(0, 4); //利用方法给成员变量赋值
		System.out.println(c.position()); //4,0
		
		//调用带参的构造方法,在创建new对象时被自动调用，构造方法必须与类同名，并且没有返回类型，常用于给成员变量赋初值
		Cell格子 c1 = new Cell格子(2,5);	
		System.out.println(c1.position()); //2,5
	}

	// 下面的“”模仿俄罗斯方块的墙，*模仿积木
	// 以下方法参数为一个对象的引用，所以传入的对象必须实例化
	public static void printWall(Cell格子 c) {
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 10; j++) {
				if (i == c.row && j == c.column) {
					System.out.print(" ");
				} else {
					System.out.print("* ");
				}
			}
			System.out.println();
		}
	}

}