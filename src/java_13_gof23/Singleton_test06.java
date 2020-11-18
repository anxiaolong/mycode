package java_13_gof23;
/**
 * ����ʽ����ģʽ��η�ֹ����ͷ����л�
 * �ٹ��������жϣ���ֹ����
 * ����readResolve��ʽ��ֱ�ӷ��ض��󣬲����½�
 */
import java.io.ObjectStreamException;
import java.io.Serializable;

@SuppressWarnings("all")
public class Singleton_test06 implements Serializable {
	private static Singleton_test06 instance;
	
	private Singleton_test06() {
		//����ģʽ�µ��ù��������´�������ֱ���׳�һ���쳣
		if (instance!=null) {
			throw new RuntimeException();
		}
	}
	
	public static synchronized Singleton_test06 getInstance() {
		if (instance==null) {
			instance = new Singleton_test06();
		}
		return instance;
	}
	
	//�����л�ʱ�����������readResolve��������ֱ�ӷ��ش˷���ָ���Ķ��󣬲���Ҫ�ٴ���
	private Object readResolve() throws ObjectStreamException {
		return instance;
	}
	
}


