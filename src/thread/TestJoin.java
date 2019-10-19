package thread;
/**
 * ����join����
 * A�������ڼ䣬���Ե����߳�B��join()�������߳�A�ͱ���ȴ��߳�Bִ����Ϻ󣬲��ܼ���ִ��
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
		System.out.println("����ȥ����");
		for (int i = 1; i < 11; i++) {
			try {
				Thread.sleep(1000);
				System.out.println("���̻���ʱ�䣺"+i+"����");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("�������̻�����");
	}
}

class Father implements Runnable {
	
	@Override
	public void run() {
		System.out.println("�ְ�����̣��ж���ȥ����");
		Son son = new Son();
		Thread sonThread = new Thread(son);
		sonThread.start();
		try {
			sonThread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("�ְ��õ����������");
	}
	
}