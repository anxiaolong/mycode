package oop;
/**
 * this代表已经创建好的对象
 * 1.形势参数和成员变量无法区分，使用this给成员变量赋值
 * 2.构造方法重载过程中，用于简化代码，但必须写在第一行
 * 3.
 * @author Administrator
 *
 */

class A{
	
	int a,b,c;
	String s;
	double d;
	
	public void test1(int a) {
		//当形势参数和成员变量冲突时候，用到this指代成员变量
		this.a = a;
	}
	
	public  A(int a,double d) {
		//构造方法重载
		this.a = a;
		this.b = b;
	}
	
	public  A(int a,String s,double d) {
		this(a, d); //调用了带参数的构造方法，可以简化代码，必须写在第一行
		this.s =s; 
	}
	public void test() {
		System.out.println("test方法");
	}
	
	public static void test2(int a) {
//		this.a = a; //statci 方法中不能使用this
	}
	
}

public class TestThis {
	public static void main(String[] args) {
		A a1 = new A(1, "anxiaolong", 3.12);
		a1.test();
	}
}
