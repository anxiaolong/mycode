package java_09_thread;
/**
 * 测试多线程生产者消费者模式
 * @author Administrator
 *
 */
class Mantou {
	int id;
	public Mantou(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return id+"号馒头";
	}
}

//生成者和消费者间设置一个缓存
class HcStack {
	int index = 0;
	Mantou[] m1 = new Mantou[10];
	
	public synchronized void push(Mantou mt) {
		while (index==m1.length) {
			try {
				wait();//如果数组装满，生产者线程进入等待
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.notify();//唤起消费者线程
		m1[index] = mt;
		index++;
	}
	
	public synchronized Mantou pop() {
		while (index==0) {
			try {
				wait();//缓存数组为空，消费者线程进入等待
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.notify();//唤起生产者线程
		index--;
		return m1[index];
	}
}

class Scz extends Thread {
	HcStack hs =null;//对象的初始化设置未null
	
	public Scz(HcStack hs) {
		this.hs = hs;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			Mantou mt = new Mantou(i);
			System.out.println("生成馒头："+mt);
			hs.push(mt);
		}
	}
}

class Xfz extends Thread {
	HcStack hs = null;
	
	public Xfz(HcStack hs) {
		this.hs = hs;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			Mantou mt = new Mantou(i);
			System.out.println("消耗馒头："+mt);
			hs.pop();
		}
	}
}

public class TestProduce {
	public static void main(String[] args) {
		HcStack hs = new HcStack();
		Scz scz = new Scz(hs);
		Xfz xfz = new Xfz(hs);
		scz.start();
		xfz.start();
	}
}
