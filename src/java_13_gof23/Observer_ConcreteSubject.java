package java_13_gof23;

public class Observer_ConcreteSubject extends Observer_Subject {
	private int state;

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
		//Ŀ��������˱仯��֪ͨ���й۲���
		this.notifyAllObservers();
	}
	
	
}
