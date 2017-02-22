package day08.oop_方法签名_方法重载_格子构造方法this_引用数组_格子T和J形状;
//模仿俄罗斯方块形状J
public class J {
	Cell格子[] cells;
	
	J(){
		this(0,0);
	}
	
	J(int row,int column){
		this.cells = new Cell格子[4];
		this.cells[0] = new Cell格子(row,column);
		this.cells[1] = new Cell格子(row,column+1);
		this.cells[2] = new Cell格子(row,column+2);
		this.cells[3] = new Cell格子(row+1,column+2);
	}
	
	void drop(){ //下落
		for(int i=0;i<this.cells.length;i++){
			this.cells[i].row++;
		}
	}
	
	void moveLeft(){//左移
		for(int i=0;i<this.cells.length;i++){
			this.cells[i].column--;
		}
	}
	
	void moveRight(){//右移
		for(int i=0;i<this.cells.length;i++){
			this.cells[i].column++;
		}
	}
	
	void print(){//打印测试
		for(int i=0;i<this.cells.length;i++){
			String str = this.cells[i].position();
			System.out.println(str);
		}
	}
}
