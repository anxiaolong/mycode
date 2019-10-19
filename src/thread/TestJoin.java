package thread;
/**
 * 测试join方法
 * A在运行期间，可以调用线程B的join()方法，线程A就必须等待线程B执行完毕后，才能继续执行
 * @author Administrator
 *
 */
public class TestJoin {
	public static void main(String[] args) {
		Father father = new Father();
		Thread faThread = new Thread(father);
		faThread.start();
	}
}

class Son implements Runnable {
	
	@Override
	public void run() {
		System.out.println("儿子去买烟");
		for (int i = 1; i < 11; i++) {
			try {
				Thread.sleep(1000);
				System.out.println("买烟花费时间："+i+"分钟");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("儿子买烟回来了");
	}
}

class Father implements Runnable {
	
	@Override
	public void run() {
		System.out.println("爸爸想抽烟，叫儿子去买烟");
		Son son = new Son();
		Thread sonThread = new Thread(son);
		sonThread.start();
		try {
			sonThread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("爸爸拿到儿子买的烟");
	}
	
}