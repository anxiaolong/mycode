package java_07_datastructure;
/**
 * ������ͨ���� �۰���� 
 * @author Administrator
 *
 */
public class Search_Test01 {
	//ʹ����ͨ���ң�ʱ�临�Ӷ�T(n)=n �ռ临�Ӷ�S(n)=1
	public static void search1(int[] array,int m) {
		for (int i = 0; i < array.length; i++) {
			if (array[i]==m) {
				System.out.println("index:"+i);
			}
		}
	}
	//��ð�ݣ����۰���� ʱ�䰴���Ӷ�Ϊlog2(n)
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
		System.out.println("δ�ҵ�");
	}
	public static void main(String[] args) {
		int[] array = {87,23,45,67,78,12,9,67};
		int m = 99;
		search1(array, m);
		search2(array, m);
	}
}
