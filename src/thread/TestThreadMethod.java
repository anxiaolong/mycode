package thread;
/**
 * ����Thread�ೣ�÷���
 * �����߳����ȼ������ȼ���1-10��ֻ���ƻ�õ��ȵĸ��ʣ������Ƶ��ȵľ���˳��
 * @author Administrator
 *
 */
public class TestThreadMethod {
	public static void main(String[] args) throws InterruptedException {
		TestThreadMethod1 t1 = new TestThreadMethod1();
		Thread t = new Thread(t1);
		Thread tt = new Thread(new TestThreadMethod1());
		t.setPriority(10);//���ȼ�1-10��ֻ���ƻ�õ��ȵĸ���
		tt.setPriority(1);
		t.setName("t");
		tt.setName("tt");
		t.start();
		tt.start();
//		t.start();
//		t.setPriority(1);//�����̵߳����ȼ���
//		System.out.println(t.getPriority());//��ȡ�̵߳����ȼ���
//		t.setName("testThread");//�����߳���
//		System.out.println(t.getName());//��ȡ�߳���
//		System.out.println(t.isAlive());//�ж��߳��Ƿ���ֹ

	}
}

class TestThreadMethod1 implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			//currentThread()��ȡ�������е��̶߳���
			System.out.println(Thread.currentThread().getName()+" "+(i+1));
		}
	}
}