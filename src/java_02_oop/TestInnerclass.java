package java_02_oop;
/**
 * 1.内部类外部类成员变量和方法的访问
 * 2.静态内部类的使用，不需要对应的外部类对象
 * 3.方法中定义内部类
 * @author Administrator
 *
 */

public class TestInnerclass {
	private int age = 27;
	public static void main(String[] args) {
		TestInnerclass.TestInnerclass1 t1 = new TestInnerclass().new TestInnerclass1();
		t1.getAge();
		//静态内部类，没有对应的外部类对象，不能使用TestInnerclass的构造器，直接调用自己的构造方法就行
		//和静态方法类似，可以直接使用
		TestInnerclass.TestInnerclass2 t2 = new TestInnerclass.TestInnerclass2();
		t2.test();
	}
	public class TestInnerclass1 {
		public int age = 20;
		public void getAge() {
			int age = 10;
			System.out.println(age); //访问方法内变量
			System.out.println(this.age); //访问内部类成员变量
			System.out.println(TestInnerclass.this.age); //访问外部内成员变量
			//在方法中定义一个内部内，作用域仅在方法内
			class TestInnerclass3 {
				public void test() {
					System.out.println("方法中的内部类执行");
				}
			}
			TestInnerclass3 sInnerclass3 = new TestInnerclass3();
			sInnerclass3.test();
		} 
	}
	static class TestInnerclass2 {
		//定义一个静态内部类
		public void test() {
			System.out.println("静态内部内方法执行");
		}
	}	
}

