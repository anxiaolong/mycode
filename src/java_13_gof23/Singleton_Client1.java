package java_13_gof23;
/**
 * ���Լ��ֵ���ģʽ��ʵ��
 * @author Administrator
 *
 */
public class Singleton_Client1 {
	public static void main(String[] args) {
		Singleton_test02 s1 = Singleton_test02.getInstance();
		Singleton_test02 s2 = Singleton_test02.getInstance();
		
		//���s1==s2,����ģʽʵ�ֳɹ�
		System.out.println(s1);
		System.out.println(s2);
		
		//����ö�ٵ���ģʽʵ��
		System.out.println(Singleton_test05.instance==Singleton_test05.instance);
	}
}
