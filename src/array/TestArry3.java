package array;
/**
 * ����Arrays���³��÷���
 */
import java.util.Arrays;

public class TestArry3 {
	//��ӡ����
	public static void test1() {
		String[] s = {"see","ggg","eef"};
		System.out.println(Arrays.toString(s)); //Arrays���toString������ӡ����
	}
	//����sort������������������
	public static void test2() {
		int[] i = {34,33,5,55,31,23,3};
		Arrays.sort(i); //��С��������
		System.out.println(Arrays.toString(i));
		String[] strings = {"rdd","ref","bdg","tyujj"};
		Arrays.sort(strings);
		System.out.println(Arrays.toString(strings));
	}
	//��������
	public static void test3() {
		Man[] m = {new Man(32),new Man(12),new Man(18)};
		System.out.println(Arrays.toString(m));
		Arrays.sort(m);
		System.out.println(Arrays.toString(m));
	}
	//�۰���� ������ ��ʹ��Arrays.binarySearch����
	public static void test4() {
		int[] a = {2,45,55,3,45,78,23,34,21};
		Arrays.sort(a); //�۰������Ҫ�ȶ���������
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.binarySearch(a, 66)); //�Ҳ���������ظ���
	}
	//������䷽��fill
	public static void test5() {
		String[] strings = {"dgeg","hhh","erwf","tff"};
		Arrays.fill(strings, 0,1,"anxiaolong"); //�±�Ϊ��0��1���滻Ϊ���ַ���
		System.out.println(Arrays.toString(strings));
	}
	public static void main(String[] args) {
		test1();
		test2();
		test3();
		test4();
		test5();
	} 
}

//����Ҫ������Ҫʵ��Comparable�ӿ�
class Man implements Comparable { 
	int age;
	String name;
	
	public Man(int age) {
		this.age = age;
	}
	
	@Override
	public int compareTo(Object o) {
		Man man = (Man)o;
		if (this.age>man.age) {
			return 1; //����ֵ1��-1 Ӱ������ķ�ʽ����С�����Ӵ�С
		} else if (this.age<man.age) {
			return -1;
		}
		return 0;
	}
}


