package java_02_oop;

class TestStatic3 {
	int a;
	int b;
	
	//statci 修饰的语句块中的代码，在类的加载类的时候就会被执行
	static {
		System.out.println("statci用于静态初始化块"); 
	}
}


public class TestStatic2 {
	public static void main(String[] args) {
		TestStatic3 test1 = new TestStatic3();
	}
	
}
