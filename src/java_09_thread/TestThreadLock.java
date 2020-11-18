package java_09_thread;
/**
 * 测试线程死锁，原因是因为同一个同步块synchronized包含多个对象锁
 * @author Administrator
 *
 */
public class TestThreadLock {
	public static void main(String[] args) {
		MakeUp m1 = new MakeUp("小红", false);
		MakeUp m2 = new MakeUp("小兰", true);
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
		System.out.println(getName()+"启动");
		toMakUp();
	}
	
	void toMakUp() {
		if (flag) {
			synchronized (k) {
				System.out.println(this.name+"使用口红");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				synchronized (j) {
					System.out.println(this.name+"使用镜子");
				}
			}
		} else {
			synchronized (j) {
				System.out.println(this.name+"使用镜子");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				synchronized (k) {
					System.out.println(this.name+"使用口红");
				}
			}
		}	
	}
}