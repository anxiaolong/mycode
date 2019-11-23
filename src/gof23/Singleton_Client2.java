package gof23;
/**
 * ����ʽ����ģʽ��η�ֹ����ͷ����л�
 * �ٹ��������жϣ���ֹ����
 * ����readResolve��ʽ��ֱ�ӷ��ض��󣬲����½�
 */
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

public class Singleton_Client2 {
	public static void main(String[] args) throws Exception {
		Singleton_test06 s1 = Singleton_test06.getInstance();
		Singleton_test06 s2 = Singleton_test06.getInstance();
		
		System.out.println(s1);
		System.out.println(s2);
		
		//����ͨ�������л���ʽ����������
		FileOutputStream fos = new FileOutputStream("C:/test/a.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(s1);
		oos.close();
		fos.close();
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:/test/a.txt"));
		Singleton_test06 s3 = (Singleton_test06)ois.readObject();
		System.out.println(s3);
		
		//����ͨ���������˽�й�����
		Class<Singleton_test06> clz = (Class<Singleton_test06>) Class.forName("gof23.Singleton_test06");
		Constructor<Singleton_test06> c = clz.getDeclaredConstructor();
		c.setAccessible(true);
		Singleton_test06 s4 = c.newInstance();
		Singleton_test06 s5 = c.newInstance();
		
		System.out.println(s4);
		System.out.println(s5);
	}
}	
