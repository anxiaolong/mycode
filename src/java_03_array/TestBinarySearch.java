package java_03_array;
/**
 * ���ֲ��Ҳ���
 */
import java.util.Arrays;

public class TestBinarySearch {
	//�۰����
	public static int test1(int[] array,int value) {
		//����Ҫ������������������ֲ���
		Arrays.sort(array);
		System.out.println(Arrays.toString(array));
		int low = 0;
		int hig = array.length-1; //low��hig������ʾ����Ǳ꣬���Գ���ֵӦ��-1
		//�˴�����ʹ����ѭ����û���ҵ���������ѭ����ѭ��������low��hig��ֵ��仯���Ҳ������ջ�����low<=hig����
		while (low<=hig) {
			int mid = (low+hig)/2;
			if (array[mid]==value) {
				System.out.println(mid);
				return 1;
			}
			if (array[mid]>value) {
				hig = mid-1;
			}
			if (array[mid]<value) {
				low = mid+1;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5,6,7,8,9};
		test1(a, 8);
	}
}
