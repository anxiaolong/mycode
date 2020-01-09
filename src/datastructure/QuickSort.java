package datastructure;
/**
 * 测试快速排序算法
 */
import java.util.Arrays;

public class QuickSort {
	public static void main(String[] args) {
		//测试排序的数组
		int[] array = {99,78,65,87,43,12,65,55,43,98};
		System.out.println(Arrays.toString(array));
		
		//快速排序
		quickSort(array);
		
		//输出有序数组
		System.out.println(Arrays.toString(array));
	}

	public static void quickSort(int[] array) {
		int low = 0;
		int high = array.length-1;
		quickSort(array,low,high);
	}

	private static void quickSort(int[] array, int low, int high) {
		if (low<high) {
			//分区操作，将一个数组分为两个分区，返回分区界限索引
			int index = partition(array,low,high);
			//对左分区进行快排
			quickSort(array,low,index-1);
			//对右分区进行快排
			quickSort(array,index+1,high);
		}
	}

	private static int partition(int[] array, int low, int high) {
		//指定左指针i和右指针j
		int i = low;
		int j = high;
		
		//将第一个数作为基准数，挖坑
		int x = array[low];
		
		//使用循环实现分区操作
		while (i<j) {
			//1.从右往左移动j，找到第一个小于基准值的array[j]
			while (array[j]>=x&&i<j) {
				j--;
			}
			//2.将右侧找到小于array[j]的值，加入到左边的坑,左指针向右移动一个位置
			if (i<j) {
				array[i]=array[j];
				i++;
			}
			//3.从左向右移动i，找到第一个大于基准值的值array[i]
			while (array[i]<x&&i<j) {
				i++;
			}
			//4.将左侧找到的大于基准值的数，填入右遍坑中，右指针向左移动一个位置
			if (i<j) {
				array[j]=array[i];
				j--;
			}
		}
		//使用基准值填坑，这就是基准值的最终位置
		array[i] = x;
		//返回基准值的位置索引
		return i;
	}
}
