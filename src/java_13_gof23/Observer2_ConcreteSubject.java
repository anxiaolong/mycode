package java_13_gof23;
/**
 * 通过继承Observable类，创建目标类
 */
import java.util.Observable;

public class Observer2_ConcreteSubject extends Observable {
	private int state;
	
	public void set(int s) {
		this.state = s;
		setChanged(); //表示目标对象已经发生改变
		notifyObservers(state);//通知所有观察者
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	
	
}
