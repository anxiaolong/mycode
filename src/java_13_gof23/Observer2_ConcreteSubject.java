package java_13_gof23;
/**
 * ͨ���̳�Observable�࣬����Ŀ����
 */
import java.util.Observable;

public class Observer2_ConcreteSubject extends Observable {
	private int state;
	
	public void set(int s) {
		this.state = s;
		setChanged(); //��ʾĿ������Ѿ������ı�
		notifyObservers(state);//֪ͨ���й۲���
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	
	
}
