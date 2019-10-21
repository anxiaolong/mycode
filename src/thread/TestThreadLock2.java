package thread;
/**
 * ����߳�������һ��ͬ������ֻ����һ��������
 * @author Administrator
 *
 */
class Lipstick1 {}

class Mirror1 {}

class MakeUp2 extends Thread {
	String name;
	boolean flag;
	static Lipstick1 k1 = new Lipstick1();
	static Mirror1 m1 = new Mirror1();
	
	public MakeUp2(String name,boolean flag) {
		this.name = name;
		this.flag = flag;
	}
	
	@Override
	public void run() {
		toMakeUp();
	}
	
	public void toMakeUp() {
		if (flag) {
			synchronized (k1) {
				System.out.println(name+"ʹ�ÿں�");
				try {
					sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			synchronized (m1) {
				System.out.println(name+"ʹ�þ���");
			}
		} else {
			synchronized (m1) {
				System.out.println(name+"ʹ�þ���");
				try {
					sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			synchronized (k1) {
				System.out.println(name+"ʹ�ÿں�");
			}
		}
	}
}

public class TestThreadLock2 {
	public static void main(String[] args) {
		MakeUp2 g1 = new MakeUp2("С��", true);
		MakeUp2 g2 = new MakeUp2("С��", false);
		g1.start();
		g2.start();
	}
}