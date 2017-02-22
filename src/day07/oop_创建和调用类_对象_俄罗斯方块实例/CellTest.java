package day07.oop_创建和调用类_对象_俄罗斯方块实例;

public class CellTest {
	public static void main(String[] args) {
		/*
		 * Cell c = new Cell(); //创建格子对象 c.row = 2; //访问成员变量
		 * c.column = 5; c.drop(); //调用方法 c.moveLeft(3); String str =
		 * c.position(); System.out.println(str); //3,2
		 */
		Cell c = new Cell();
		// 这里的c放在椎空间保存的是指向堆的地址，new Cell()放在堆空间
		// 如果设置c=null ，则会断开指向堆的内存，并且=null后指向属性和方法都会空指针异常
		// int a = 5; 放在椎空间。

		c.row = 2;
		c.column = 5;
		printWall(c);

		System.out.println("\n下落后...");
		c.drop();
		printWall(c);

		System.out.println("\n左移3格");
		c.moveLeft(3);
		printWall(c);
	}

	// 下面的“”模仿俄罗斯方块的墙，*模仿积木
	// 以下方法参数为一个对象的引用，所以传入的对象必须实例化
	public static void printWall(Cell c) {
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