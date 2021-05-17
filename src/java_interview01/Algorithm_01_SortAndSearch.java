package java_interview01;
/**
 * ð��������۰����
 */
import java.util.Arrays;

public class Algorithm_01_SortAndSearch {
	public static void main(String[] args) {
		int[] arr = {78,43,67,23,12,55,66,33,21,99,76};
		bubbleSort(arr);
		System.out.println(Arrays.toString(arr));
		
		binarySearch(arr,99);
	}
	
	//�۰����
	private static void binarySearch(int[] arr,int i) {
		int low = 0;
		int high = arr.length;
		while (low<high) {
			int mid = (low+high)/2;
			if (arr[mid]>i) {
				high--;
			}
			if (arr[mid]<i) {
				low++;
			}
			if (arr[mid]==i) {
				System.out.println("index:"+mid);
				return;
			}
		}
		System.out.println("δ�ҵ�");
	}
	
	//ð������
	public static void bubbleSort(int[] arr) {
		//5.ÿ�����������Ƚ�һ��
				for (int j = 0; j < arr.length; j++) {
					//1.����Ƚ��ҵ�������
					for (int i = 0; i < arr.length; i++) {
						int temp = 0;//2.���彻��ֵ�ı���
						if ((i+1)<arr.length) {//4.��֤������Խ��
							if (arr[i]>arr[i+1]) {//3.�ٽ��������Լ�С������λ��
								temp = arr[i+1];
								arr[i+1] = arr[i];
								arr[i] = temp;
							}
						}
					}
				}
		}
}
