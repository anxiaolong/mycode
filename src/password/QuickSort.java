package password;
/**
 * ���������㷨
 * ��õ�����ǣ�ÿ�������з֣����Ӷ�ΪO(nlogn) 
 * �����������Ӷ�ΪO(n^2)
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
			//�ָ����鲢���ػ�׼����index
			int index = splitArray(arr,low,high);
			//�ָ��������������
			quickSort(arr, low, index-1);
			//�ָ��������������
			quickSort(arr, index+1, high);
		}
	}

	private static int splitArray(int[] arr, int low, int high) {
		//�������һ������Ϊ��׼
		int x = arr[low];
		while (low<high) {
			//�ҵ��ұ�С��x�ĵ�һ��������ӵ����
			while (arr[high]<=x&&low<high) {
				high--;
			}
			//��Ӳ���lowǰ��һλ
			if (low<high) {
				arr[low] = arr[high];
				low++;
			}
			//����ҵ�����x�ĵ�һ����,��ӵ��ұ�
			while (arr[low]>=x&&low<high) {
				low++;
			}
			//��ӣ�����high��һλ
			if (low<high) {
				arr[high] = arr[low];
				high--;
			}
		}
		//��ʱ��low==high
		arr[high] = x;
		return high;
	}
}
