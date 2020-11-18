package java_13_gof23;
/**
 * ����ʹ�þ�̬�ڲ���ʵ�ֵ���ģʽ
 * �ŵ㣺�̰߳�ȫ������Ч�ʸߡ�ʵ����������
 * @author Administrator
 *
 */
public class Singleton_test04 {
	private static class SingletonClassInstance {
		private static final Singleton_test04 instance = new Singleton_test04();
	}
	
	private Singleton_test04() {}
	
	//����û���߳�ͬ��������Ч�ʸ�
	public static Singleton_test04 getInstance() {
		return SingletonClassInstance.instance;
	}
}
