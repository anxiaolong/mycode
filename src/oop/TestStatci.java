package oop;

import java.util.jar.Attributes.Name;

class  Test {
	int a; //这是一个普通的成员变量，对象才能使用
	static String name = "anxiaolong"; //静态变量从属于类
	
	//static修饰的是静态方法，从属于类
	public static void test() {
		System.out.println("static方法");
	}
	
	public void test(int a) {
		System.out.println("普通方法");
	}
}

public class TestStatci {
	public static void main(String[] args) {
		System.out.println(Test.name); //静态变量可以直接调用
		Test Test1 = new Test();
		Test1.a = 222;
		System.out.println(Test1.a); //普通变量，针对对象使用
	}
}
