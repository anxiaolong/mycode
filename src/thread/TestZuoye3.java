package thread;
/**
 * 用两个线程打印有序的序列，测试线程通信的方法
 * 注意线程通信的顺序，wait()和notify()的顺序
 * @author Administrator
 *
 */
class Printer {
	int index=1;
	
	public void printNum(int i) {
		synchronized (this) {
			if (index%3==0) {
				try {
					wait();//本线程进入等待阶段，抛出对象锁
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				notify();//唤起处于等待对象锁的线程
			} 
			System.out.print(i);
			(this.index)++;
		}
	}
	
	public void printChar(char c) {
		synchronized (this) {
			if (index%3!=0) {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.print(c);
			notify();
			(this.index)++;
		}
	}
}

class Pnum extends Thread {
	Printer p;
	
	public Pnum(Printer p) {
		this.p = p;
	}
	
	@Override
	public void run() {
		for (int i = 1; i < 53; i++) {
			p.printNum(i);
		}
	}
}

class Pchar extends Thread {
	Printer p;
	
	public Pchar(Printer p) {
		this.p = p;
	}
	
	@Override
	public void run() {
		char a = 'A';
		for (int i = 1; i < 27; i++) {
			p.printChar(a);
			a+=1;
		}
	}
}

public class TestZuoye3 {
	public static void main(String[] args) {
		Printer p = new Printer();
		Pnum pnum = new Pnum(p);
		Pchar pchar = new Pchar(p);
		pnum.start();
		pchar.start();
	}
}

