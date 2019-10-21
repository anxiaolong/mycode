package thread;
/**
 * �����߳�ͬ��synchronized
 * synchronized����ڷ����м�synchronized����
 * synchronized����Ʋ����Ķ��󣬱������в��ʺ�ʹ���ڷ����м�synchronized��
 * ��Ϊ����������������֮�������߳��Ѿ�����������жϣ��޷��ﵽĿ��
 * @author Administrator
 *
 */
public class TestSync {
	public static void main(String[] args) {
		Account account = new Account("�й�����", 100);
		DrawMoney d1 = new DrawMoney(account, 80);
		DrawMoney d2 = new DrawMoney(account, 80);
		d1.start();
		d2.start();
	}
}

class Account {
	String bankString;
	int money;
	
	public Account(String banString,int money) {
		this.bankString = banString;
		this.money = money;
	}
}

class DrawMoney extends Thread {
	Account account;
	int drawMoney;
	
	public DrawMoney(Account account,int drawMoney) {
		this.account = account;
		this.drawMoney = drawMoney;
	}
	
	@Override
	public void run() {
		synchronized (account) {
			if (account.money-drawMoney<=0) {
				System.out.println("�˻�Ǯ����");
				return;
			}
			try {
				sleep(1000);//�߳��������ȴ������߳�����
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//��account����Ĳ����������жϺ��߳�����֮�����������߳���ͨ���жϲ���ģ���ȡ������
			this.account.money -= drawMoney;
		}
		System.out.println(this.getName()+"ȡǮ��"+drawMoney);
		System.out.println("�˻�ʣ�ࣺ"+this.account.money);
	}
}
