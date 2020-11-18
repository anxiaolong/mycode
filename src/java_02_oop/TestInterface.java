package java_02_oop;
/**
 * 接口的多继承
 * 内部类对象创建
 * 接口的实现
 * 接口成员变量默认：public static final
 * 接口方法默认：public abstract
 * @author Administrator
 *
 */

public class TestInterface {
	public static void main(String[] args) {
		//创建内部类的对象
		Cxy c1Cxy = new TestInterface().new Cxy();
		c1Cxy.run();
		c1Cxy.jump();
		c1Cxy.sport();
		c1Cxy.xuexi();
		c1Cxy.age = 27; //给内部类进行赋值
		
	}
	
	//定义一个内部类，继承Human又实现接口Man
	public class Cxy extends Human implements Man  {
		int age;
		public void run() {
			System.out.println("跑"+Run.a+"米");
		}
		public void jump() {
			System.out.println("跳"+Jump.a+"米");
		}
		public void sport() {
			System.out.println("运动");
		}
		public void xuexi() {
			System.out.println("写代码");
		}
	}
}

interface Run {
	public static final int a = 1000;
	public abstract void run(); //接口方法中没有实现，默认是public abstract修饰
}

interface Jump {
	public static final int a = 1;
	public abstract void jump();
}

//接口可以多继承
interface Man extends Run,Jump {
	public abstract void sport();
}

class Human {
	public void xuexi() {
		System.out.println("学习");
	}
}