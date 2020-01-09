package password;
/**
 * 快速排序算法
 * 最好的情况是，每次正好中分，复杂度为O(nlogn) 
 * 最差情况，复杂度为O(n^2)
 */
import java.util.Arrays;

public class QuickSort {
	public static void main(String[] args) {
		int[] arr = {89,45,32,56,77,88,43,12,44,51};
		System.out.println(Arrays.toString(arr));
		quickSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void quickSort(int[] arr) {
		int low = 0;
		int high = arr.length-1;
		quickSort(arr,low,high);
	}

	private static void quickSort(int[] arr, int low, int high) {
		if (low<high) {
			//分割数组并返回基准数的index
			int index = splitArray(arr,low,high);
			//分隔开后，左边再排序
			quickSort(arr, low, index-1);
			//分隔开后，左边再排序
			quickSort(arr, index+1, high);
		}
	}

	private static int splitArray(int[] arr, int low, int high) {
		//把数组第一个数作为基准
		int x = arr[low];
		while (low<high) {
			//找到右遍小于x的第一个数，填坑到左边
			while (arr[high]<=x&&low<high) {
				high--;
			}
			//填坑并把low前移一位
			if (low<high) {
				arr[low] = arr[high];
				low++;
			}
			//左边找到大于x的第一个数,填坑到右遍
			while (arr[low]>=x&&low<high) {
				low++;
			}
			//填坑，并把high减一位
			if (low<high) {
				arr[high] = arr[low];
				high--;
			}
		}
		//这时候low==high
		arr[high] = x;
		return high;
	}
}
