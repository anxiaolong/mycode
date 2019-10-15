package io;
/**
 * ����װ����ģʽ����һ�����װ����һ���࣬������������
 * @author Administrator
 *
 */
public class TestDecoration {
	public static void main(String[] args) {
		SuperMan man1 = new SuperMan(new Man("Jack"));
		man1.fly();
	}
}

//��ͨ��ֻ����·�ķ���
class Man {
	String name;
	
	public Man(String name) {
		this.name = name;
	}
	
	public void walk() {
		System.out.println("Man can walk");
	}
}
//ͨ����װ��ͨ�˱䳬�˿��Է�
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