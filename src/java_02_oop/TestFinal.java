package java_02_oop;

public class TestFinal {
	public static void main(String[] args) {
		TestFinal2 testFinal2 = new TestFinal2();
//		testFinal2.a = 1; //不可对final修饰的成员变量赋值
	}
}

final class TestFinal1 {
	
}

//final 修饰的类不能被继承
//class TestFinal2 extends TestFinal1 {
//	
//}

class TestFinal2 {
	final int a = 10;
	
	final void test() {
		System.out.println("eeee");
	}
	//final修饰的方法可以被重载
	final void test(int a) {
		System.out.println(a);
	}
}

class TestFinal3 extends TestFinal2 {
	//final 修饰的方法不能被重写
//	final void test() {
//		System.out.println("eeee");
//	}
}
