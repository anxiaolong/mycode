package java_13_gof23;
/**
 * 测试观察者模式
 * @author Administrator
 *
 */
public class Observer_Client {
	public static void main(String[] args) {
		//目标对象
		Observer_ConcreteSubject subject = new Observer_ConcreteSubject();
		
		//创建多个观察者
		Observer_ObserverA obs1 = new Observer_ObserverA();
		Observer_ObserverA obs2 = new Observer_ObserverA();
		Observer_ObserverA obs3 = new Observer_ObserverA();
		
		//将观察者对象加入到list中
		subject.registerObserver(obs1);
		subject.registerObserver(obs2);
		subject.registerObserver(obs3);
		
		//改变subject的状态
		subject.setState(900);
		System.out.println("####################");
		//查看观察者状态是否变更
		System.out.println(obs1.getMyState());
		System.out.println(obs2.getMyState());
		System.out.println(obs3.getMyState());
		
		//改变subject的状态
		subject.setState(888);
		System.out.println("####################");
		//查看观察者状态是否变更
		System.out.println(obs1.getMyState());
		System.out.println(obs2.getMyState());
		System.out.println(obs3.getMyState());
	}
}
