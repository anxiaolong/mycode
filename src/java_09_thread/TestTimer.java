package java_09_thread;
/**
 * ����Timer���TimerTask��
 */
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

public class TestTimer {
	public static void main(String[] args) {
		Timer t = new Timer();
		Mytask mt = new Mytask();
//		t.schedule(mt, 3000);//ʵ�ֶ�ʱ����3���ʼִ��
		t.schedule(mt,3000,2000);//3���ʼִ�У�ÿ2��ִ��һ��
//		GregorianCalendar calendar1 = new GregorianCalendar(2019, 10, 22, 15, 23, 1);//ִ��ʱ������
//		t.schedule(mt,calendar1.getTime());
	}
}

class Mytask extends TimerTask {

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("ִ���������"+i);
		}
	}
}