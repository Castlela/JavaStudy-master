package day09.oop_内存管理_继承_super_向上造型;

public class Z extends Tetromino父类{
	Z(){
		this(0,0);
	}
	
	Z(int row,int column){
		//super(); //系统默认生成，用于调用父类无参构造
		cells[0] = new Cell(row,column);
		cells[1] = new Cell(row,column+1);
		cells[2] = new Cell(row+1,column+1);
		cells[3] = new Cell(row+1,column+2);
	}
}
