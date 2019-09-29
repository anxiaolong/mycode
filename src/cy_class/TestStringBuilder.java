package cy_class;
/**
 * ���Կɱ��ַ�����StringBuilder��StringBuffer���÷�
 * �Ƚ�String��StringBuilder�Ĳ�������
 * @author Administrator
 *
 */
public class TestStringBuilder {
	//�ɱ��ַ���StringBuilder
	public static void test1() {
		StringBuilder a = new StringBuilder();
		for (int i = 0; i < 10; i++) {
			a.append((char)('a'+i));
		}
		System.out.println(a.toString()); //ת�����ַ������
		System.out.println(a.append(",test")); //׷���ַ���
		
		//����StringBuffer
		StringBuffer a1 = new StringBuffer("anxiaolong");
		a1.insert(0, 'T').insert(1, 'G'); //�����ַ�
		System.out.println(a1);
		a1.delete(0, 2); //ɾ���ַ���
		System.out.println(a1);
		System.out.println(a1.deleteCharAt(0)); //ɾ��ĳ��λ���ַ�
		System.out.println(a1.charAt(3)); //��ȡĳ��λ���ַ�
		System.out.println(a1.reverse()); //�ַ�������
	}
	//Stringƴ���ַ�����StringBuilder���ܶԱ�
	public static void test2() {
		String aString = new String("anxiaolong");
		long m1 = Runtime.getRuntime().freeMemory();
//		System.out.println(m1);
		long t1 = System.currentTimeMillis();
//		System.out.println(t1);
		for (int i = 0; i < 1000; i++) {
			aString += i;
		}
		System.out.println(aString);
		long m2 = Runtime.getRuntime().freeMemory();
		long t2 = System.currentTimeMillis();
		System.out.println("�����ڴ棺"+(m1-m2));
		System.out.println("����ʱ�䣺"+(t2-t1));
		
		StringBuffer aBuffer = new StringBuffer("anxiaolong");
		long m1_ = Runtime.getRuntime().freeMemory();
		long t1_ = System.currentTimeMillis();
		for (int i = 0; i < 1000; i++) {
			aBuffer.append(i);
		}
		System.out.println(aBuffer);
		long m2_ = Runtime.getRuntime().freeMemory();
		long t2_ = System.currentTimeMillis();
		System.out.println("�����ڴ棺"+(m1_-m2_));
		System.out.println("����ʱ�䣺"+(t2_-t1_));
	}
	public static void main(String[] args) {
		test1();
		test2();
	}
		
}
