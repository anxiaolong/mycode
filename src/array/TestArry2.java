package array;
/**
 * ʹ��ѭ����������
 * for-each��ȡ�����е�����
 * ���鿽��������System.arraycopy(src, srcPos, dest, destPos, length); 
 * @author Administrator
 *
 */
public class TestArry2 {
	//ѭ����������
	public static void test1() {
		int[] a = new int[8];
		for (int i = 0; i < a.length; i++) {
			a[i] = i;
		}
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
	//ʹ��for-each��������,ֻ��ȡ����������
	public static void test2() {
		String[] a = {"ddd","iiff","ddkk"};
		for (String string : a) {
			System.out.println(string);
		}
	}
	//����Ŀ���
	public static void test3() {
		String a[] = {"rr","dd","bbb"};
		String[] b = new String[6];
		System.arraycopy(a, 0, b, 3, a.length); //length��Դ����ĳ���
//		System.arraycopy(src, srcPos, dest, destPos, length);  
		/*srcPos:Դ������ĸ��±꿪ʼ����  destPos��Ŀ��������ĸ��±꿪ʼճ�� length��Դ����ĳ���*/
		for (String string : b) {
			System.out.println(string);
		}
	}
	public static void main(String[] args) {
		test1();
		test2();
		test3();
	}
}
