package thread;
/**
 * ������ֹ�̵߳ĵ��ͷ�ʽ
 * ����һ������ֵ��Ϊ��ֹ������
 * ��ʹ��stop()/destroy()������ֹ�߳�
 * @author Administrator
 *
 */
public class TestStopThread implements Runnable {
	String name;
	boolean live = true;//�趨һ������ֵ��������Ϊ��ֹ�̵߳�����
	
	public TestStopThread(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		int i = 0;
		while (live) {//��liveΪfalseʱ��run�������н��ܣ��߳�Ҳ��ֹ
			System.out.println(name+(i++));
		}
	}
	
	public void terminate() {
		live = false;
	}
	
	public static void main(String[] args) {
		TestStopThread t1 = new TestStopThread("�߳�");
		Thread thread1 = new Thread(t1);
		thread1.start();
		for (int i = 0; i < 21; i++) {
			System.out.println("���߳�"+i);
		}
		t1.terminate();
		System.out.println("�߳���ֹ");
	}
}
