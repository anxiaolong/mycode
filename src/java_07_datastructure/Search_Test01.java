package java_07_datastructure;
/**
 * 测试普通查找 折半查找 
 * @author Administrator
 *
 */
public class Search_Test01 {
	//使用普通查找，时间复杂度T(n)=n 空间复杂度S(n)=1
	public static void search1(int[] array,int m) {
		for (int i = 0; i < array.length; i++) {
			if (array[i]==m) {
				System.out.println("index:"+i);
			}
		}
	}
	//先冒泡，在折半查找 时间按复杂度为log2(n)
	public static void search2(int[] array,int m) {
		for (int j = 0; j < array.length; j++) {
			for (int i = 0; i < array.length; i++) {
				int temp=0;
				if (i+1>=array.length) {
					break;
				}
				if (array[i]>array[i+1]) {
					temp = array[i+1];
					array[i+1]=array[i];
					array[i]=temp;
				}
			}
		}
		
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]+" ");
		}
		
		int low = 0;
		int high = array.length-1;
		while (low<=high) {
			int mid = (low+high)/2;
			if (array[mid]==m) {
				System.out.println("index:"+mid);
				return;
//				break;
			}else if (array[mid]>m) {
				high--;
			}else if (array[mid]<m) {
				low++;
			}
		}
		System.out.println("未找到");
	}
	public static void main(String[] args) {
		int[] array = {87,23,45,67,78,12,9,67};
		int m = 99;
		search1(array, m);
		search2(array, m);
	}
}
