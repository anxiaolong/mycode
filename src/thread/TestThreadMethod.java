package thread;
/**
 * 测试Thread类常用方法
 * 测试线程优先级，优先级数1-10，只控制获得调度的概率，不控制调度的绝对顺序
 * @author Administrator
 *
 */
public class TestThreadMethod {
	public static void main(String[] args) throws InterruptedException {
		TestThreadMethod1 t1 = new TestThreadMethod1();
		Thread t = new Thread(t1);
		Thread tt = new Thread(new TestThreadMethod1());
		t.setPriority(10);//优先级1-10，只控制获得调度的概率
		tt.setPriority(1);
		t.setName("t");
		tt.setName("tt");
		t.start();
		tt.start();
//		t.start();
//		t.setPriority(1);//设置线程的优先级数
//		System.out.println(t.getPriority());//获取线程的优先级数
//		t.setName("testThread");//设置线程名
//		System.out.println(t.getName());//获取线程名
//		System.out.println(t.isAlive());//判断线程是否终止

	}
}

class TestThreadMethod1 implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			//currentThread()获取正在运行的线程对象
			System.out.println(Thread.currentThread().getName()+" "+(i+1));
		}
	}
}