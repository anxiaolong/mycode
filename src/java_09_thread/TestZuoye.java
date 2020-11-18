package java_09_thread;
/**
 * 模拟5个站点同时售票的情况
 */
import java.util.ArrayList;

public class TestZuoye {
	public static void main(String[] args) {
		Tickets tickets = new Tickets();//车票数只有20张
		int thread = 5;//线程数5
		ArrayList<Thread> listThread = new ArrayList<Thread>();
		for (int i = 0; i < thread; i++) {
			listThread.add(new Thread(new SellTickets("售票点"+i, tickets)));//用容器储存线程对象
		}
		for (Thread thread2 : listThread) {
			thread2.start();//遍历线程对象并运行
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
		while (flag<5) {//假定每个线程都会接受5个买票的请求
			synchronized (tickets) {//每个线程都需要操作tickets对象，设置同步
				if (tickets.num<=0) {
					System.out.println("票卖完了");
					return;
				}
				System.out.println(this.Name+"卖出一张票");
				(tickets.num)--;
			}
			flag++;
		}
	}
}