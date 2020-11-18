package java_09_thread;
/**
 * 测试sleep和yield方法
 * sleep只是造成暂时阻塞，不会释放cpu资源
 * yield是直接进入就绪状态，释放cpu资源
 * @author Administrator
 *
 */
public class TestSleepAndYield {
	public static void main(String[] args) {
		TestSleep ts = new TestSleep();
//		ts.start();
		TestYield ty = new TestYield();
		ty.start();
		TestYield ty2 = new TestYield();
		ty2.start();
	}
}

class TestSleep extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(this.getName()+i);
			try {
				this.sleep(2000);//sleep方法是造成临时堵塞，不会释放资源
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class TestYield extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(this.getName()+" "+i);
			this.yield();
		}
	}
}
