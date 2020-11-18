package java_13_gof23;
/**
 * ���Թ۲���ģʽ
 * @author Administrator
 *
 */
public class Observer_Client {
	public static void main(String[] args) {
		//Ŀ�����
		Observer_ConcreteSubject subject = new Observer_ConcreteSubject();
		
		//��������۲���
		Observer_ObserverA obs1 = new Observer_ObserverA();
		Observer_ObserverA obs2 = new Observer_ObserverA();
		Observer_ObserverA obs3 = new Observer_ObserverA();
		
		//���۲��߶�����뵽list��
		subject.registerObserver(obs1);
		subject.registerObserver(obs2);
		subject.registerObserver(obs3);
		
		//�ı�subject��״̬
		subject.setState(900);
		System.out.println("####################");
		//�鿴�۲���״̬�Ƿ���
		System.out.println(obs1.getMyState());
		System.out.println(obs2.getMyState());
		System.out.println(obs3.getMyState());
		
		//�ı�subject��״̬
		subject.setState(888);
		System.out.println("####################");
		//�鿴�۲���״̬�Ƿ���
		System.out.println(obs1.getMyState());
		System.out.println(obs2.getMyState());
		System.out.println(obs3.getMyState());
	}
}
