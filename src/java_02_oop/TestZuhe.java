package java_02_oop;
/**
 * �������Ϊ��ϳ�һ����
 * @author Administrator
 *
 */


public class TestZuhe {
	Cpu c;
	Memory m;
	Disk d;
	public void run() {
		c.run();
		m.run();
		d.run();
	}
	public static void main(String[] args) {
		TestZuhe computer = new TestZuhe();
		computer.c = new Cpu();
		computer.m = new Memory();
		computer.d = new Disk();
		computer.run();
	}
}

class Cpu {
	public void run() {
		System.out.println("cpu����");
	}
}

class Memory {
	public void run() {
		System.out.println("�ڴ�����");
	}
}

class Disk {
	public void run() {
		System.out.println("Ӳ������");	
	}
}