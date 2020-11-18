package java_02_oop;
/**
 * 多个类作为组合成一个类
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
		System.out.println("cpu运行");
	}
}

class Memory {
	public void run() {
		System.out.println("内存运行");
	}
}

class Disk {
	public void run() {
		System.out.println("硬盘运行");	
	}
}