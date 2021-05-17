package java_interview01;
/**
 * 冒泡排序和折半查找
 */
import java.util.Arrays;

public class Algorithm_01_SortAndSearch {
	public static void main(String[] args) {
		int[] arr = {78,43,67,23,12,55,66,33,21,99,76};
		bubbleSort(arr);
		System.out.println(Arrays.toString(arr));
		
		binarySearch(arr,99);
	}
	
	//折半查找
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
		System.out.println("未找到");
	}
	
	//冒泡排序
	public static void bubbleSort(int[] arr) {
		//5.每个数都拿来比较一次
				for (int j = 0; j < arr.length; j++) {
					//1.逐个比较找到最大的数
					for (int i = 0; i < arr.length; i++) {
						int temp = 0;//2.定义交换值的变量
						if ((i+1)<arr.length) {//4.保证索引不越界
							if (arr[i]>arr[i+1]) {//3.临近索引比自己小，交换位置
								temp = arr[i+1];
								arr[i+1] = arr[i];
								arr[i] = temp;
							}
						}
					}
				}
		}
}
