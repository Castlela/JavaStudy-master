package day09.oop_内存管理_继承_super_向上造型;

public class Tetromino父类 {
	Cell[] cells; //格式数组
	
	public Tetromino父类() {
		cells = new Cell[4]; //？这句话是怎么执行？
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
	
	void print(){ //打印测试，输出每个格式的行列位置
		for(int i=0;i<this.cells.length;i++){
			String str = this.cells[i].position();
			System.out.println(str);
		}
	}
	
}
