package array;

import java.util.Arrays;

public class TestZuoye {
	//�ַ����������
	public static int test1(String array[],String value) {
		for (int i = 0; i < array.length; i++) {
			if (array[i]==value) {
				System.out.println("Yes");
				return 1;
			}
		}
		System.out.println("No");
		return -1;
	}
	//���������ֵ����Сֵ������60���ĸ���
	public static void test2() {
		int[] a = new int[50];
		for (int i = 0; i < a.length; i++) {
			int num = (int)(100*Math.random());
			a[i] = num;		
		}
		for (int j = 0; j < a.length; j++) {
			for (int i = 0; i < a.length-1-j; i++) {
				if (a[i]>a[i+1]) {
					int tmp = a[i];
					a[i] = a[i+1];
					a[i+1] = tmp;
				}
			}
		}	
		System.out.println(Arrays.toString(a));
		System.out.println("���ֵ��"+a[49]);
		System.out.println("��Сֵ��"+a[0]);
		for (int i = 0; i < a.length; i++) {
			if (a[i]>=60) {
				System.out.println(a[i]);
				System.out.println("����60��������Ϊ��"+(a.length-i));
				break;
			}
		}
	}
	//���������������������
	public static void test3() {
		int[] a = new int[10];
		for (int i = 0; i < a.length; i++) {
			int num = (int)(10*Math.random());
			a[i] = num;
		}
		System.out.println(Arrays.toString(a));
		int hig = a.length-1;
		for (int i = 0; i < a.length; i++) {
			if (i<hig) {
				int tmp = a[i];
				a[i] = a[hig];
				a[hig] = tmp;
			}
			hig--;
		}
		System.out.println(Arrays.toString(a));	
	}
	
	public static void main(String[] args) {
		String[] aStrings = {"ttrfb","ddfe","ewef","pocc","inue"};
		test1(aStrings, "ewef");
		test1(aStrings, "sss");
		test2();
		test3();

	}
}
