package thread;
/**
 * 测试通过继承Thread类和实现Runnable接口实现多线程
 * @author Administrator
 *
 */
//通过继承Thread类实现多线程
public class TestThread extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(this.getName()+":"+i);
		}
	}
	public static void main(String[] args) {
		TestThread t1 = new TestThread();
		t1.start();
		TestThread t2 = new TestThread();
		t2.start();
		//实现runnable接口的类，间接创建一个Thread对象来实现多线程
		Thread t3 = new Thread(new TestRunnable());
		t3.start();
		Thread t4 = new Thread(new TestRunnable());
		t4.start();
	}
}

//通过实现Runnable接口实现多线程
class TestRunnable implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName()+":"+i);
		}
	}
}