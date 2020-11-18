package java_02_oop;
/**
 * abstract修饰的类，不能new
 * abstract修饰的方法，必须在子类重写
 * abstract方法的类，必须用abstract修饰
 * @author Administrator
 *
 */
public class TestAbstract {
	public static void main(String[] args) {
//		TestAbstract1 testAbstract1 = new TestAbstract1(); //abstract修饰的类不能new对象
		TestAbstract2 t1 = new TestAbstract2();
		t1.run();
	}
}

abstract class TestAbstract1 { //有abstract方法的类，必须用abstract修饰
	abstract void run(); //abstract 修饰的方法没有实现的语句块
}

class TestAbstract2 extends TestAbstract1 {
	//继承父类abstract方法，必须要重写
	public void run() { 
		System.out.println("跑");
	}
}