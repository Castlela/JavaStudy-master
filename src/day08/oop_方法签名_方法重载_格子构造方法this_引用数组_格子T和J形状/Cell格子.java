package day08.oop_方法签名_方法重载_格子构造方法this_引用数组_格子T和J形状;
//构造方法、this关键字
public class Cell格子 {
	int row; // 行号
	int column; // 列号

	//如果没有重构构造方法，则系统会自动生成默认无参构造
	Cell格子(){
		row = 0;
		column = 0;
	}
	
	//构造方法参数不限，只要方法标识不一样
	//当定义了构造方法，系统将不再自动生成默认的无参构造方法
	//构造方法必须与类同名，并且没有返回类型和不能写void，常用于给成员变量赋初值
	Cell格子(int row,int column){//局部变量
		this.row = row;//如果这里没有加this,就近原则来说，都是指当前方法的局部变量
		this.column = column;//俄罗斯方块重构方法 c = new 俄罗斯方块重构方法(2,5);
	}                        //this.column 相当于c.column
	                         //this.成员变量   访问成员变量
							 //this.方法名() 调用方法，不常用
							 //this() 调用构造方法，常用于构造方法间互相调用
	
	Cell格子(int n){
		this(n,n); //调用构造方法，常用于构造方法间互相调用
	}
	
	//给成员变量赋值(模仿构造方法)
	/*void setInfo(int row1,int column1){
		row = row1;
		column = column1;
	}*/
	void setInfo(int row, int column) {
		this.row = row; 
		this.column = column; 
							  
	}
	
	void drop() { // 下落一格
		row++; // 行号+1
	}

	//方法重载
	void drop(int n){
		row+=n;
	}
	
	//方法重载
	void moveLeft(){
		column--;
	}
	
	void moveLeft(int n) { // 左移n格
		column-=n; // 列号n
	}

	void moveRight(){
		column++;
	}

	void moveRight(int n){
		column+=n;
	}
	
	String position() { // 获取行号和列号（位置）
		return row + "," + column;
	}
}