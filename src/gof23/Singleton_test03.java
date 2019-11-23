package gof23;
/**
 * ˫�ؼ����ʵ�ֵ���ģʽ��һ�㲻�ã�
 * @author Administrator
 *
 */
public class Singleton_test03 {
	private static Singleton_test03 instance = null;
	
	public static Singleton_test03 getInstance() {
		if (instance==null) {
			Singleton_test03 sc;
			synchronized (Singleton_test03.class) {
				sc = instance;
				if (sc==null) {
					synchronized (Singleton_test03.class) {
						if (sc==null) {
							sc = new Singleton_test03();
						}
					}
					instance = sc;
				}
				
			}
		}
		return instance;
	}
	
	private Singleton_test03() {
		// TODO Auto-generated constructor stub
	}
}
