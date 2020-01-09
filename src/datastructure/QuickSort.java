package datastructure;
/**
 * ���Կ��������㷨
 */
import java.util.Arrays;

public class QuickSort {
	public static void main(String[] args) {
		//�������������
		int[] array = {99,78,65,87,43,12,65,55,43,98};
		System.out.println(Arrays.toString(array));
		
		//��������
		quickSort(array);
		
		//�����������
		System.out.println(Arrays.toString(array));
	}

	public static void quickSort(int[] array) {
		int low = 0;
		int high = array.length-1;
		quickSort(array,low,high);
	}

	private static void quickSort(int[] array, int low, int high) {
		if (low<high) {
			//������������һ�������Ϊ�������������ط�����������
			int index = partition(array,low,high);
			//����������п���
			quickSort(array,low,index-1);
			//���ҷ������п���
			quickSort(array,index+1,high);
		}
	}

	private static int partition(int[] array, int low, int high) {
		//ָ����ָ��i����ָ��j
		int i = low;
		int j = high;
		
		//����һ������Ϊ��׼�����ڿ�
		int x = array[low];
		
		//ʹ��ѭ��ʵ�ַ�������
		while (i<j) {
			//1.���������ƶ�j���ҵ���һ��С�ڻ�׼ֵ��array[j]
			while (array[j]>=x&&i<j) {
				j--;
			}
			//2.���Ҳ��ҵ�С��array[j]��ֵ�����뵽��ߵĿ�,��ָ�������ƶ�һ��λ��
			if (i<j) {
				array[i]=array[j];
				i++;
			}
			//3.���������ƶ�i���ҵ���һ�����ڻ�׼ֵ��ֵarray[i]
			while (array[i]<x&&i<j) {
				i++;
			}
			//4.������ҵ��Ĵ��ڻ�׼ֵ�����������ұ���У���ָ�������ƶ�һ��λ��
			if (i<j) {
				array[j]=array[i];
				j--;
			}
		}
		//ʹ�û�׼ֵ��ӣ�����ǻ�׼ֵ������λ��
		array[i] = x;
		//���ػ�׼ֵ��λ������
		return i;
	}
}
