package day08.oop_方法签名_方法重载_格子构造方法this_引用数组_格子T和J形状;

public class Z {
Cell格子[] cells;
	
	Z(){
		this(0,0);
	}
	
	Z(int row,int column){
		cells[0] = new Cell格子(row,column);
		cells[1] = new Cell格子(row,column+1);
		cells[2] = new Cell格子(row+1,column+1);
		cells[3] = new Cell格子(row+1,column+2);
	}
	
	void drop(){
		for(int i=0;i<cells.length;i++){
			cells[i].row++;
		}
	}
	
	void moveLeft(){
		for(int i=0;i<cells.length;i++){
			cells[i].column--;
		}
	}
	
	void moveRight(){
		for(int i=0;i<cells.length;i++){
			cells[i].column++;
		}
	}
	
	void print(){
		for(int i=0;i<cells.length;i++){
			String str = cells[i].position();
			System.out.println(str);
		}
	}
}
