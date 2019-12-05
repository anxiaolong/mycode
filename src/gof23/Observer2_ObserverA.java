package gof23;
/**
 * 通过实现Observer接口，创建观察者类
 */
import java.util.Observable;
import java.util.Observer;

public class Observer2_ObserverA implements Observer {
	private int myState;
	
	@Override
	public void update(Observable o, Object arg) {
		myState = ((Observer2_ConcreteSubject)o).getState();
	}

	public int getMyState() {
		return myState;
	}

	public void setMyState(int myState) {
		this.myState = myState;
	}

	
}
