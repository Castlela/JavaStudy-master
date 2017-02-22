package day10.oop_继承里的重写_重写重载区别_package和import_修饰符_static_final;
//模仿俄罗斯方块形状T
//super
public class T extends Tetromino父类{ //继承父类，就可以直接使用成员变量cells
//	Cell[] cells; //如果这里写了cells默认是用使用当前类的cells，会出现空指针异常
	T(){ //无参构造
		this(0,0);
	}
	
	T(int row,int column){ //有参构造
		//super();//super指当前对象的父类对象，这里的super如果不写，不管子类构造有无参都会默认调用父类的构造方法,必须放子类构造的第一行，而且父类必须要有无参构造 
		          //super.成员变量 //调用当前类父类的成员变量
		          //super.方法名 //调用当前类父类的方法
		          //super() //调用当前类父类的构造方法
	    //java规定，构造子类前，先构造父类，如果没有手动调用，则系统会自动调用父类的无参构造super();
		super.cells[0] = new Cell(row,column);
		//这里如果写this也不会报错，因为继承关系，cells已属于子类的一部份
		this.cells[1] = new Cell(row,column+1);
		super.cells[2] = new Cell(row,column+2);
		super.cells[3] = new Cell(row+1,column+1);
	}

	//重写了父类的print方法
	@Override
		void print() {
			System.out.println("I'm T");
			super.print(); //为什么这里调用父类的print能把成员变量打印出来？那是因为调用前已赋值了
		}
}
