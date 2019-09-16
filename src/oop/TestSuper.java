package oop;
/**
 * 测试super的使用，调用父类方法和成员变量
 * @author Administrator
 *
 */
public class TestSuper {
	public static void main(String[] args) {
		TestSuper2 t1 = new TestSuper2(2,3);
		t1.testSuper();
	}
}

class TestSuper1 {
	int a;
	int b;
	static String name = "anxiaolong";
	
	public void test() {
		System.out.println("这是父类方法");
	}
	public TestSuper1(int a) {
		this.a = a;
	}
	
	//不写这个为空的构造方法，子类重写构造方法会报错
	public TestSuper1() {
		// TODO Auto-generated constructor stub
	}
	
}

class  TestSuper2 extends TestSuper1 {
	String name;
	
	public void testSuper() {
		super.test(); //调用父类的方法
		System.out.println("调用父类成员变量:"+super.name); //调用父类成员变量
	}
	public TestSuper2(int a,int b) {
		this.a = a;
		this.b = b;
	}
}