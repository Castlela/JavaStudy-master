package day11.oop_static_final常量_抽象方法_抽象类_接口;
//打一组图形中的最大面积,抽象类
public class AbstractShapeTest {
	public static void main(String[] args) {
		//new Shape(); //编译错误，抽象类不能被实例化
		
		Shape[] shapes = new Shape[4];//创建Shape数组
		shapes[0] = new Square(1);
		shapes[1] = new Square(2);
		shapes[2] = new Circle(1);
		shapes[3] = new Circle(2);
		maxArea(shapes);
	}
	
	public static void maxArea(Shape[] shapes){
		double max = shapes[0].area(); //假设shapes[0]是最大面试
		int maxIndex = 0; //假设最大下
		for(int i=1;i<shapes.length;i++){
			if(max < shapes[i].area()){
				max = shapes[i].area();
				maxIndex = i;
			}
		}
		System.out.println("最大面积:"+max+"  所在下标为:"+maxIndex);
	}
}
//-----------------------------------------------------
abstract class Shape{//抽象类
	protected double c;//周长
	abstract public double area(); //抽象方法
	//public void print(){}  //抽象类可以包含普通方法
}
//-----------------------------------------------------
class Square extends Shape{
	public Square(double c) {
		this.c = c;
	}
	public double area() { //继承抽象类，必须重写抽象方法
		return 0.0625*c*c;
	}
}
//-----------------------------------------------------
class Circle extends Shape{
	public Circle(double c) {
		this.c = c;
	}
	public double area() { //继承抽象类，必须重写抽象方法
		return 0.0796*c*c;
	}
}


