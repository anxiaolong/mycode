package pro01;

public class TestOverload {
	public static void main(String[] args) {
		System.out.println(Jia(1, 3.12));
		System.out.println(Jia(1, 1, 1));
		System.out.println(Jia(3.99, 8));
		
		Jia("anxiaolong");
		
	}
	
	public static  double Jia(int a,double b) {
		return a+b;
	}
	//��������ͬ������������ͬ����������
	public static int Jia(int a,int b,int c) {
		return a+b+c;
	}
	//��������ͬ��������ͬ����������
	public static void Jia(String s) {
		System.out.println(s);
	}
	//��������ͬ������˳��ͬ����������
	public static  double Jia(double a,int b) {
		return a+b;
	}
	//ֻ�з���ֵ��ͬ������������
	//ֻ�в������Ʋ�ͬ������������
}

