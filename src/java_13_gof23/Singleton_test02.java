package java_13_gof23;
/**
 * ��������ʽ����ģʽ
 * @author Administrator
 *
 */
public class Singleton_test02 {
	//��ʼ�������У�����new����
	private static Singleton_test02 instance;
	
	private Singleton_test02() {} //˽�л�������
	
	//����ʹ��ʱ���new������Ϊ�������߳�ͬ��������Ч�ʵ�
	public static synchronized Singleton_test02 getInstance() {
		if (instance==null) {
			instance = new Singleton_test02();
		}
		return instance;
	}
}
