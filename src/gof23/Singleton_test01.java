package gof23;
/**
 * ���Զ���ʽ����ģʽ
 * ����ģʽ��һ����ֻ��һ����Ӧ�Ķ���
 * @author Administrator
 *
 */
public class Singleton_test01 {
	//�������ͬʱ������������ȱ����û��������
	public static Singleton_test01 instance = new Singleton_test01();
	
	private Singleton_test01() {}
	
	//����Ч�ʸߣ�û���߳�ͬ��
	public static Singleton_test01 getInstance() {
		return instance;
	}
}
