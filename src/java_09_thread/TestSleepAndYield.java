package java_09_thread;
/**
 * ����sleep��yield����
 * sleepֻ�������ʱ�����������ͷ�cpu��Դ
 * yield��ֱ�ӽ������״̬���ͷ�cpu��Դ
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
				this.sleep(2000);//sleep�����������ʱ�����������ͷ���Դ
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
