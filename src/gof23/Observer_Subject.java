package gof23;

import java.util.ArrayList;
import java.util.List;

public class Observer_Subject {
	protected List<Observer_Observer> list = new ArrayList<Observer_Observer>();
	
	public void registerObserver(Observer_Observer obs) {
		list.add(obs);
	}
	
	public void removeObserver(Observer_Observer obs) {
		list.remove(obs);
	}
	
	//֪ͨ���еĹ۲��߸���״̬
	public void notifyAllObservers() {
		for (Observer_Observer obs : list) {
			obs.update(this);
		}
	}
}
