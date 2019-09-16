package oop;
/**
 * 构造方法是从父类向下执行
 * @author Administrator
 *
 */

public class TestSuperGz {
	public static void main(String[] args) {
		new TestTestSuperGz3();
	}
}

class TestTestSuperGz1 {
	
	public TestTestSuperGz1() {
		System.out.println("执行了1代构造方法");
	}
}

class TestTestSuperGz2 extends TestTestSuperGz1 {
	
	public TestTestSuperGz2() {
		System.out.println("执行了2代构造方法");
	}
}

class TestTestSuperGz3 extends TestTestSuperGz2 {
	
	public TestTestSuperGz3() {
		System.out.println("执行了3代构造方法");
	}
}