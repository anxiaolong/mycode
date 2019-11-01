package httpserver;
/**
 * ����Java���䣬�ص�����Class.forName("����.����")
 */
import java.lang.reflect.InvocationTargetException;

public class TestReflect {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, NoSuchMethodException, SecurityException, InvocationTargetException {
		//��ͨ�������󷽷�
		Iphone iPhone5 = new Iphone();
		//1.ͨ�� ����.getClass() ��ȡ��
		Class clz = iPhone5.getClass();
		//2.ͨ����.class��ʽ����Class����
		Class clz2 = Iphone.class;
		//3��Class.forName("����.����")
		Class clz3 = Class.forName("httpserver.Iphone");
		//ͨ��Class���󴴽�����
		Iphone iphone6 =(Iphone)clz.getConstructor().newInstance();
		Iphone iphone7 =(Iphone)clz2.getConstructor().newInstance();
		Iphone iphone8 =(Iphone)clz3.getConstructor().newInstance();
		System.out.println(iphone6);
		System.out.println(iphone7);
		System.out.println(iphone8);
	}
}

class Iphone {
	public Iphone() {
		// TODO Auto-generated constructor stub
	}
}