package thread;
/**
 * 测试终止线程的典型方式
 * 定义一个布尔值作为终止的条件
 * 不使用stop()/destroy()方法终止线程
 * @author Administrator
 *
 */
public class TestStopThread implements Runnable {
	String name;
	boolean live = true;//设定一个布尔值，用来作为终止线程的条件
	
	public TestStopThread(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		int i = 0;
		while (live) {//当live为false时，run方法运行接受，线程也终止
			System.out.println(name+(i++));
		}
	}
	
	public void terminate() {
		live = false;
	}
	
	public static void main(String[] args) {
		TestStopThread t1 = new TestStopThread("线程");
		Thread thread1 = new Thread(t1);
		thread1.start();
		for (int i = 0; i < 21; i++) {
			System.out.println("主线程"+i);
		}
		t1.terminate();
		System.out.println("线程终止");
	}
}
