package java_13_gof23;
/**
 * ���Լ��ֵ���ģʽ��������õ�Ч��
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
		
		countDownLatch.await();//main�߳�������֪����������Ϊ0���ż�������ִ��
		
		long end = System.currentTimeMillis();
		System.out.println("�ܺ�ʱ��"+(end-start));
	}
}
