package day07.oop_创建和调用类_对象_俄罗斯方块实例;

public class Cell {
	int row; // 行号
	int column; // 列号

	void drop() { // 下落一格
		row++; // 行号+1
	}

	void moveLeft(int n) { // 左移n格
		column = n; // 列号n
	}

	String position() { // 获取行号和列号（位置）
		return row + "," + column;
	}
}