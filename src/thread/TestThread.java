package thread;
/**
 * ����ͨ���̳�Thread���ʵ��Runnable�ӿ�ʵ�ֶ��߳�
 * @author Administrator
 *
 */
//ͨ���̳�Thread��ʵ�ֶ��߳�
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
		//ʵ��runnable�ӿڵ��࣬��Ӵ���һ��Thread������ʵ�ֶ��߳�
		Thread t3 = new Thread(new TestRunnable());
		t3.start();
		Thread t4 = new Thread(new TestRunnable());
		t4.start();
	}
}

//ͨ��ʵ��Runnable�ӿ�ʵ�ֶ��߳�
class TestRunnable implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName()+":"+i);
		}
	}
}