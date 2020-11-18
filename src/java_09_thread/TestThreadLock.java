package java_09_thread;
/**
 * �����߳�������ԭ������Ϊͬһ��ͬ����synchronized�������������
 * @author Administrator
 *
 */
public class TestThreadLock {
	public static void main(String[] args) {
		MakeUp m1 = new MakeUp("С��", false);
		MakeUp m2 = new MakeUp("С��", true);
		m1.start();
		m2.start();
	}
}

class Lipstick {}

class Mirro {}

class MakeUp extends Thread {
	static Lipstick k = new Lipstick();
	static Mirro j = new Mirro();
	String name;
	boolean flag;
	
	public MakeUp(String name,Boolean flag) {
		this.name = name;
		this.flag = flag;
	}
	
	@Override
	public void run() {
		System.out.println(getName()+"����");
		toMakUp();
	}
	
	void toMakUp() {
		if (flag) {
			synchronized (k) {
				System.out.println(this.name+"ʹ�ÿں�");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				synchronized (j) {
					System.out.println(this.name+"ʹ�þ���");
				}
			}
		} else {
			synchronized (j) {
				System.out.println(this.name+"ʹ�þ���");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				synchronized (k) {
					System.out.println(this.name+"ʹ�ÿں�");
				}
			}
		}	
	}
}