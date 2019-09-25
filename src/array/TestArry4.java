package array;
/**
 * ��ά������������ʼ��
 * ��ά����洢�������
 */
import java.util.Arrays;

public class TestArry4 {
	//��ά��������
	private static void test1() {
		int[][] a = new int[3][]; 
		a[0] = new int[2];
		a[1] = new int[3];
		a[2] = new int[4];	
		System.out.println(Arrays.toString(a)); //����aֻ��������ַ
	}
	//��ά���龲̬��ʼ��
	public static void test2() {
		int[][] a = {{1,3,5},{2},{4,5}};
		System.out.println(a[0][2]);
//		System.out.println(Arrays.toString(a[1][])); //a[1][]�������߼������Ϊһ�����飬���ǲ���ʹ��array��ķ���
		System.out.println(Arrays.toString(a[1]));
	}
	//��ά���鶯̬��ʼ����һά��ά���鳤�Ȼ�ȡ
	public static void test3() {
		int[][] a = new int[3][];
		a[0] = new int[] {1,2};
		a[1] = new int[] {3,6,1};
		a[2] = new int[] {8};
		System.out.println(a[1][1]);
		System.out.println(Arrays.toString(a[1])); 
		System.out.println(Arrays.toString(a[2]));
		System.out.println(a.length); //һά���鳤��
		System.out.println(a[1].length); //��ά���鳤��
	}
	//ʹ�ö�ά����洢�������
	public static void test4() {
		Object[][] a = new Object[3][];
		a[0] = new Object[] {"anxiaolong",27,122,3.234};
		a[1] = new Object[] {345,"adec","deff","deff"};
		a[2] = new Object[] {"innif",23,"didgf",'c'};
		System.out.println(Arrays.toString(a[0]));
		System.out.println(Arrays.toString(a[1]));
		System.out.println(Arrays.toString(a[2]));
	}
	public static void main(String[] args) {
		test1();
		test2();
		test3();
		test4();
	}
}
