package day08.oop_方法签名_方法重载_格子构造方法this_引用数组_格子T和J形状;
//模仿俄罗斯方块形状T
public class T {
	Cell格子[] cells; //格式数组
	
	T(){ //无参构造
		this(0,0);
	}
	
	T(int row,int column){ //有参构造
		//Cell格子[] cells = new Cell格子[4]; 注意这里不要重复声明，否则创建对象时只会给局部对象赋值，而成员变量的值为null
		this.cells = new Cell格子[4];
		this.cells[0] = new Cell格子(row,column);
		this.cells[1] = new Cell格子(row,column+1);
		this.cells[2] = new Cell格子(row,column+2);
		this.cells[3] = new Cell格子(row+1,column+1);
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
