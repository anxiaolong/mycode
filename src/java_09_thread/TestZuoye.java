package java_09_thread;
/**
 * ģ��5��վ��ͬʱ��Ʊ�����
 */
import java.util.ArrayList;

public class TestZuoye {
	public static void main(String[] args) {
		Tickets tickets = new Tickets();//��Ʊ��ֻ��20��
		int thread = 5;//�߳���5
		ArrayList<Thread> listThread = new ArrayList<Thread>();
		for (int i = 0; i < thread; i++) {
			listThread.add(new Thread(new SellTickets("��Ʊ��"+i, tickets)));//�����������̶߳���
		}
		for (Thread thread2 : listThread) {
			thread2.start();//�����̶߳�������
		}
	}
}

class Tickets {
	int num = 20;
}

class SellTickets implements Runnable {
	String Name;
	Tickets tickets;
	
	public SellTickets(String name,Tickets tickets) {
		this.Name = name;
		this.tickets = tickets;
	}
	
	@Override
	public void run() {
		int flag = 0;
		while (flag<5) {//�ٶ�ÿ���̶߳������5����Ʊ������
			synchronized (tickets) {//ÿ���̶߳���Ҫ����tickets��������ͬ��
				if (tickets.num<=0) {
					System.out.println("Ʊ������");
					return;
				}
				System.out.println(this.Name+"����һ��Ʊ");
				(tickets.num)--;
			}
			flag++;
		}
	}
}