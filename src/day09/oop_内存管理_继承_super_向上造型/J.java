package day09.oop_内存管理_继承_super_向上造型;
//模仿俄罗斯方块形状J
public class J extends Tetromino父类{

	J(){
		this(0,0);
	}
	
	J(int row,int column){
		//super(); //系统默认生成，用于调用父类无参构造 
		this.cells[0] = new Cell(row,column);
		this.cells[1] = new Cell(row,column+1);
		this.cells[2] = new Cell(row,column+2);
		this.cells[3] = new Cell(row+1,column+2);
	}
}
