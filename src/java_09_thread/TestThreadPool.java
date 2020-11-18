package java_09_thread;
/**
 * 测试四种线程池
 */
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TestThreadPool {
	//1.缓存线程池，长度无限，执行完的线程回自动回收利用
	public static void testThreadCachedPool() {
		ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++) {
			final int index = i;
			try {
				Thread.sleep(index*1000); //如果屏蔽掉sleep时间，就回创建多个线程
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
	
	//2.定长线程池，线程数量定死，线程不够用需要等待
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
	
	//3.周期线程池，可实现定时等功能
	public static void scheduledThreadPool() {
		ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(3);
		
//		scheduledThreadPool.schedule(new Runnable() {
//			@Override
//			public void run() {
//				System.out.println("延迟3秒");
//			}
//		}, 3, TimeUnit.SECONDS);
		
		scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Hello");
			}
		}, 3, 1, TimeUnit.SECONDS);
	}
	
	//4.单线程执行
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
