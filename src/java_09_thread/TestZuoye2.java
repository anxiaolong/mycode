package java_09_thread;
/**
 * 模拟10个人（线程）过山洞，记录通过顺序和线程对象名
 */
import java.util.ArrayList;
import java.util.List;

public class TestZuoye2 {
	public static void main(String[] args) {
		Cave cave = new Cave();
		List<Pass> listpass = new ArrayList<Pass>();
		for (int i = 1; i < 11; i++) {
			Pass p = new Pass(i, cave);
			listpass.add(p);
		}
		for (Pass pass : listpass) {
			pass.start();
		}
	}
}

//山洞类
class Cave {
	int order = 1;//用于记录通过的顺序
}

//线程类
class Pass extends Thread {
	int id;
	Cave cave = null;
	
	public Pass(int id,Cave cave) {
		this.id = id;
		this.cave = cave;
	}
	
	@Override
	public void run() {
		synchronized (cave) {
			System.out.println(this.id+"通过山洞...");
			try {
				sleep(2000);//中间阻塞2秒模拟通过时间
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(this.id+"通过完成，顺序："+cave.order);
			cave.order++;
		}
	}
}