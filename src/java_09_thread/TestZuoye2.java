package java_09_thread;
/**
 * ģ��10���ˣ��̣߳���ɽ������¼ͨ��˳����̶߳�����
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

//ɽ����
class Cave {
	int order = 1;//���ڼ�¼ͨ����˳��
}

//�߳���
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
			System.out.println(this.id+"ͨ��ɽ��...");
			try {
				sleep(2000);//�м�����2��ģ��ͨ��ʱ��
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(this.id+"ͨ����ɣ�˳��"+cave.order);
			cave.order++;
		}
	}
}