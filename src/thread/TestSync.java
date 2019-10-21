package thread;
/**
 * 测试线程同步synchronized
 * synchronized块和在方法中加synchronized修饰
 * synchronized块控制操作的对象，本案例中不适合使用在方法中加synchronized，
 * 因为操作对象是在阻塞之后，其他线程已经启动完成了判断，无法达到目的
 * @author Administrator
 *
 */
public class TestSync {
	public static void main(String[] args) {
		Account account = new Account("中国银行", 100);
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
				System.out.println("账户钱不够");
				return;
			}
			try {
				sleep(1000);//线程阻塞，等待其他线程运行
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//对account对象的操作，放在判断和线程阻塞之后，让其他的线程先通过判断才能模拟出取出负数
			this.account.money -= drawMoney;
		}
		System.out.println(this.getName()+"取钱："+drawMoney);
		System.out.println("账户剩余："+this.account.money);
	}
}
