package java_09_thread;
/**
 * ���������̳߳�
 */
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TestThreadPool {
	//1.�����̳߳أ��������ޣ�ִ������̻߳��Զ���������
	public static void testThreadCachedPool() {
		ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++) {
			final int index = i;
			try {
				Thread.sleep(index*1000); //������ε�sleepʱ�䣬�ͻش�������߳�
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			cachedThreadPool.execute(new Runnable() {
				
				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName());
					System.out.println(index);
				}
			});
		}
	}
	
	//2.�����̳߳أ��߳������������̲߳�������Ҫ�ȴ�
	public static void testFixedThreadPool() {
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
		for (int i = 0; i < 10; i++) {
			final int index = i;
			fixedThreadPool.execute(new Runnable() {
				
				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName());
					System.out.println(index);
				}
			});
		}
	}
	
	//3.�����̳߳أ���ʵ�ֶ�ʱ�ȹ���
	public static void scheduledThreadPool() {
		ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(3);
		
//		scheduledThreadPool.schedule(new Runnable() {
//			@Override
//			public void run() {
//				System.out.println("�ӳ�3��");
//			}
//		}, 3, TimeUnit.SECONDS);
		
		scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Hello");
			}
		}, 3, 1, TimeUnit.SECONDS);
	}
	
	//4.���߳�ִ��
	public static void testSingleThreadExecutor() {
		ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
		for (int i = 0; i < 10; i++) {
			final int index = i;
			singleThreadExecutor.execute(new Runnable() {
				
				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName());
					System.out.println(index);
				}
			});
		}
	}
	
	public static void main(String[] args) {
		
	}
}
