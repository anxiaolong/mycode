package array;
/**
 * ð���㷨bubble
 */
import java.util.Arrays;

public class TestBubble {
	//ð���㷨
	public static void test1() {
		int n = 1;
		int[] a = {2,12,4,56,1,5,11};
		for (int j = 0; j < a.length; j++) {
			//a.length-1-j  -1�Ǳ���i+1�±�Խ�� -j��Ϊ�������Ƚ�Ч�ʣ�����Ҫ�ٺͱȽϳ����������бȽ�
			for (int i = 0; i < a.length-1-j; i++) { 
				int tmp = 0;
				if (a[i]>a[i+1]) {
					tmp = a[i];
					a[i] = a[i+1];
					a[i+1] = tmp;
				}
				System.out.println(n); //���������˶��ٴ�ѭ��
				n++;
			}
		}	
		System.out.println(Arrays.toString(a)); 
	}
	//ð���㷨�Ż�
	public static void test2() {
		int n = 1;
		int[] a = {1,0,2,5,6,7,11};
		for (int j = 0; j < a.length; j++) {
			//���岼����ʶ
			boolean flag=true;
			//a.length-1-j  -1�Ǳ���i+1�±�Խ�� -j��Ϊ�������Ƚ�Ч�ʣ�����Ҫ�ٺͱȽϳ����������бȽ�
			for (int i = 0; i < a.length-1-j; i++) { 
				int tmp = 0;
				if (a[i]>a[i+1]) {
					tmp = a[i];
					a[i] = a[i+1];
					a[i+1] = tmp;
					flag = false; //ֻҪִ����ֵ�Ľ�����falg��ֵ����false�����ѭ�������ִ��
				} 
				System.out.println(n); //���������˶��ٴ�ѭ��
				n++;
			}
			//����ڲ�ѭ��û�н���ֵ�Ľ�����˵�������Ѿ��ź���ֱ���˳�ѭ��
			if (flag) {
				break;
			}
		}	
		System.out.println(Arrays.toString(a)); 
	}
	
	public static void main(String[] args) {
		test1();
		test2();
	}
}
