package java_13_gof23;

public class Observer_ConcreteSubject extends Observer_Subject {
	private int state;

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
		//目标对象发生了变化，通知所有观察者
		this.notifyAllObservers();
	}
	
	
}
