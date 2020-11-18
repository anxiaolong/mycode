package java_09_thread;
/**
 * ���Զ��߳�������������ģʽ
 * @author Administrator
 *
 */
class Mantou {
	int id;
	public Mantou(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return id+"����ͷ";
	}
}

//�����ߺ������߼�����һ������
class HcStack {
	int index = 0;
	Mantou[] m1 = new Mantou[10];
	
	public synchronized void push(Mantou mt) {
		while (index==m1.length) {
			try {
				wait();//�������װ�����������߳̽���ȴ�
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.notify();//�����������߳�
		m1[index] = mt;
		index++;
	}
	
	public synchronized Mantou pop() {
		while (index==0) {
			try {
				wait();//��������Ϊ�գ��������߳̽���ȴ�
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.notify();//�����������߳�
		index--;
		return m1[index];
	}
}

class Scz extends Thread {
	HcStack hs =null;//����ĳ�ʼ������δnull
	
	public Scz(HcStack hs) {
		this.hs = hs;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			Mantou mt = new Mantou(i);
			System.out.println("������ͷ��"+mt);
			hs.push(mt);
		}
	}
}

class Xfz extends Thread {
	HcStack hs = null;
	
	public Xfz(HcStack hs) {
		this.hs = hs;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			Mantou mt = new Mantou(i);
			System.out.println("������ͷ��"+mt);
			hs.pop();
		}
	}
}

public class TestProduce {
	public static void main(String[] args) {
		HcStack hs = new HcStack();
		Scz scz = new Scz(hs);
		Xfz xfz = new Xfz(hs);
		scz.start();
		xfz.start();
	}
}
