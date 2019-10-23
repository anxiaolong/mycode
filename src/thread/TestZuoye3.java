package thread;
/**
 * �������̴߳�ӡ��������У������߳�ͨ�ŵķ���
 * ע���߳�ͨ�ŵ�˳��wait()��notify()��˳��
 * @author Administrator
 *
 */
class Printer {
	int index=1;
	
	public void printNum(int i) {
		synchronized (this) {
			if (index%3==0) {
				try {
					wait();//���߳̽���ȴ��׶Σ��׳�������
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				notify();//�����ڵȴ����������߳�
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

