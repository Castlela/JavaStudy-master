package day08.oop_方法签名_方法重载_格子构造方法this_引用数组_格子T和J形状;

public class TJTest {

	public static void main(String[] args) {
		System.out.println("原始位置");
		T t1 = new T(2, 5);
		t1.print();

		System.out.println("左移后位置");
		t1.moveLeft();
		t1.print();
		
		System.out.println("右移后位置");
		t1.moveRight();
		t1.print();
		
		System.out.println("下落后位置");
		t1.drop();
		t1.print();
	}

}
