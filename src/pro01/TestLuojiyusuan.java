/**
 * &�� |�� !�� ^���
 * &&��·�� ||��·�� 
 */
package pro01;

public class TestLuojiyusuan {
	public static void main(String[] args) {
		boolean a = true;
		boolean b = false;
//		System.out.println(a&b);
//		System.out.println(a|b);
//		System.out.println(a^b);
//		System.out.println(!a);
		boolean c = 1>2 && 1>3/0; //��·��ֻ����1>2�������˵ڶ�������
//		boolean d = 1>2 & 1>3/0; //���ö�·ֱ�ӻᱨ��ʹ�ö�·&&��||����ߴ���Ч��
//		boolean e = 1<2 | 1>3/0; //�߼�������дҲ�ᱨ��
		boolean e = 1<2 || 1>3/0;
		System.out.println(c); 
		System.out.println(e);
	}
}
