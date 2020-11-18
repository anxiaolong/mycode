package java_09_thread;
/**
 * 测试Timer类和TimerTask类
 */
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

public class TestTimer {
	public static void main(String[] args) {
		Timer t = new Timer();
		Mytask mt = new Mytask();
//		t.schedule(mt, 3000);//实现定时器，3秒后开始执行
		t.schedule(mt,3000,2000);//3秒后开始执行，每2秒执行一次
//		GregorianCalendar calendar1 = new GregorianCalendar(2019, 10, 22, 15, 23, 1);//执行时间运行
//		t.schedule(mt,calendar1.getTime());
	}
}

class Mytask extends TimerTask {

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("执行任务代码"+i);
		}
	}
}