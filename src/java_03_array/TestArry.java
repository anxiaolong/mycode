package java_03_array;
/**
 * ����������������
 * ����������������
 * �����ʼ����Ĭ��ֵ
 */

public class TestArry {
	
	public int a,b;
	public TestArry(int a,int b) {
		this.a = a;
		this.b = b;
	}
	//����������������
	public static void test1() {
		int[] a = null; //����һ�����飬��ʼ��Ϊ��
		a = new int[10]; //���������ռ�
//		System.out.println(a.length); //a�����鳤��Ϊ10
		//�����鸳ֵ
		for (int i = 0; i < a.length; i++) {
			a[i] = i;
			System.out.println(a[i]);
		}
	}
	
	//����������������
	public static void test2() {
		TestArry[] test; //����������������test,����������������������
		test = new TestArry[10]; //�����ö�������ڴ�ռ�
		TestArry t1Arry = new TestArry(23,22);
		TestArry t2Arry = new TestArry(1,2);
		test[0] = t1Arry;
		test[1] = t2Arry;
		System.out.println(test[0]); //���������ڴ洢�ľ��Ƕ���ĵ�ַ
	}
	
	//�����ʼ����Ĭ��ֵ
	public static void test3() {
		int[] a  = {1,2,3}; //��̬��ʼ��������������
		TestArry[] a1 = {new TestArry(1, 1),new TestArry(3, 5)}; //��̬��ʼ��������������
		//��̬��ʼ��
		int[] a2 = new int[2]; //����ռ�
		System.out.println(a2[0]); //Ĭ��ֵΪ0 
		System.out.println(a2[1]); 
		a2[0] = 1;
		a2[1] = 2;
		boolean[] a3 = new boolean[1];
		System.out.println(a3[0]); //boolean����Ĭ��ֵΪfalse
		String[] a4 = new String[1];
		System.out.println(a4[0]); //string����Ĭ��ֵΪnull
		TestArry[] a5 = new TestArry[1];
		System.out.println(a5[0]); //��������Ĭ��ֵҲΪnull
	}
	
	public static void main(String[] args) {
		test1();
		test2();
		test3();
	}
}
