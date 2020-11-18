package java_13_gof23;
/**
 * 测试几种单例模式，对象调用的效率
 */
import java.util.concurrent.CountDownLatch;

public class Singleton_Client3 {
	public static void main(String[] args) throws Exception {
		long start = System.currentTimeMillis();
		int threadNum = 10;
		final CountDownLatch countDownLatch = new CountDownLatch(threadNum);
		
		for (int i = 0; i < threadNum; i++) {
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					for (int j = 0; j < 10000000; j++) {
//						Object o = Singleton_test04.getInstance();
						Object o = Singleton_test05.instance;
					}
					countDownLatch.countDown();
				}
			}).start();
			
		}
		
		countDownLatch.await();//main线程阻塞，知道计数器变为0，才继续往下执行
		
		long end = System.currentTimeMillis();
		System.out.println("总耗时："+(end-start));
	}
}
