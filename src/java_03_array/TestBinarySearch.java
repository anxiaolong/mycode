package java_03_array;
/**
 * 二分查找测试
 */
import java.util.Arrays;

public class TestBinarySearch {
	//折半查找
	public static int test1(int[] array,int value) {
		//首先要对数列排序才能做二分查找
		Arrays.sort(array);
		System.out.println(Arrays.toString(array));
		int low = 0;
		int hig = array.length-1; //low和hig用来表示数组角标，所以长度值应该-1
		//此处不能使用死循环，没有找到会陷入死循环，循环过程中low或hig的值会变化，找不到最终会跳出low<=hig条件
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
