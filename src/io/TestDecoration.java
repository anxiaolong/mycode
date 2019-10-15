package io;
/**
 * 测试装饰器模式，将一个类包装成另一个类，扩充它的能力
 * @author Administrator
 *
 */
public class TestDecoration {
	public static void main(String[] args) {
		SuperMan man1 = new SuperMan(new Man("Jack"));
		man1.fly();
	}
}

//普通人只有走路的方法
class Man {
	String name;
	
	public Man(String name) {
		this.name = name;
	}
	
	public void walk() {
		System.out.println("Man can walk");
	}
}
//通过包装普通人变超人可以飞
class SuperMan {
	Man man;
	
	public SuperMan(Man man) {
		this.man = man;
	}
	
	public void fly() {
		man.walk();
		System.out.println("superman can fly");
	}
}