package java_13_gof23;

public class Observer_ObserverA implements Observer_Observer {
	//��Ҫ��Ŀ����󱣳�һ��
	private int myState;
	
	@Override
	public void update(Observer_Subject subject) {
		myState = ((Observer_ConcreteSubject)subject).getState();
	}

	public int getMyState() {
		return myState;
	}

	public void setMyState(int myState) {
		this.myState = myState;
	}
	
	
}
