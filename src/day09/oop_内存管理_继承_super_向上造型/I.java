package day09.oop_内存管理_继承_super_向上造型;

public class I extends Tetromino父类{
	I(){
		this(0,0);
	}
	
	I(int row,int column){
		//super(); //系统默认生成，用于调用父类无参构造
		cells[0] = new Cell(row,column);
		cells[1] = new Cell(row+1,column);
		cells[2] = new Cell(row+2,column);
		cells[3] = new Cell(row+3,column);
	}
	
}
