package day09.oop_内存管理_继承_super_向上造型;
//打印T型
//向上造型
public class TJTest打印T型 {
	public static void main(String[] args) {
		//T t = new Tetromino父类(); //编译错误，父类不能指向子类
		Tetromino父类 t = new T(3,4); //这种方式叫向上造型
		printWall_2(t); //先向上造型，再传值
		
		O o = new O(); 
		printWall_2(o); //传值同时向上造型
	}
	
	//打印T型方法一 优点是速度快，效率高
	public static void printWall_1(T t){ //这里没有做向上造型，扩展性不强
		Cell[] cells = t.cells;
		for(int i=0;i<20;i++){
			for(int j=0;j<10;j++){
				if(cells[0].row == i && cells[0].column == j ||
				   cells[1].row == i && cells[1].column == j ||
				   cells[2].row == i && cells[2].column == j ||
				   cells[3].row == i && cells[3].column == j){
					System.out.print("* ");
				}else{
					System.out.print("- ");
				}
			}
			System.out.println();
		}
	}
	
	//并非一次就能判断得结果，用boolean flag 开关的方式做，此处用这种方式，效率低，因为循环多
	//当出现一个值向循环里的值做比较，并只得出一个结果的时候，用flag方法
	//用此种方式做扩展性好，但效率低，这里起码要跑20*10*4=800次，方式一只用循环20*10=200次
	//但是效率的问题，能通过升级硬件来解决
	
	//用i和j构成一个点，分别和cells的4个点去做比较，只要有一符合位置，则i和j构成的点打*，否则打-，然后再判断其他由i和j构成的位置
	public static void printWall_2(Tetromino父类 t){ //这里Tetromino父类 t 能接收t,i,j,z,o,l,s
		Cell[] cells = t.cells;
		for(int i=0;i<20;i++){
			for(int j=0;j<10;j++){
				boolean flag = false;
				for(int k=0;k<cells.length;k++){
					if(cells[k].row == i && cells[k].column == j){ 
						//i和j 是一个坐标，构成一个点，所以用ij和cells的所有点比较，最多只会匹配出一个相同的，因此用break跳出
						flag = true; //并非一次就能判断得结果，用boolean flag 开关的方式做
						break;
						//System.out.print("* ");
					}//else{
						//System.out.print("- ");
					//}
				}
				if(flag){ //这里是判断i和j是否和cells[].row和cells[].column构成的点位置一致
					System.out.print("* ");
				}else{
					System.out.print("- ");
				}
			}
			System.out.println();
		}
	}

}
