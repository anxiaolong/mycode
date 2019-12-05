package gof23;
/**
 * 测试观察者模式
 * @author Administrator
 *
 */
public class Observer2_Client {
	public static void main(String[] args) {
		Observer2_ConcreteSubject subject = new Observer2_ConcreteSubject();
		
		Observer2_ObserverA obs1 = new Observer2_ObserverA();
		Observer2_ObserverA obs2 = new Observer2_ObserverA();
		Observer2_ObserverA obs3 = new Observer2_ObserverA();
		
		subject.addObserver(obs1);
		subject.addObserver(obs2);
		subject.addObserver(obs3);
		
		subject.set(999);
		System.out.println(obs1.getMyState());
		System.out.println(obs2.getMyState());
		System.out.println(obs3.getMyState());
		
		subject.set(1088);
		System.out.println(obs1.getMyState());
		System.out.println(obs2.getMyState());
		System.out.println(obs3.getMyState());
	}
}
