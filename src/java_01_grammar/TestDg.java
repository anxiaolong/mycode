package java_01_grammar;

public class TestDg {
	
	public static void main(String[] args) {
//		System.out.println(Dg(10));
		//ʹ��ѭ��ʵ��
		int s = 1;
		for (int i = 1; i <= 10; i++) {
			s *= i;
		}
		System.out.println(s);
	}
//    public static long Dg(int a) {
//		//a==1�ǵݹ�ͷ�������ݹ�
//		if (a == 1) {
//			return 1;	
//		} else {
//			//����a*Dg(a-1)�ǵݹ���
//			return a*Dg(a-1);
//		}
//	}

}
