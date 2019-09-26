package array;
/**
 * 冒泡算法bubble
 */
import java.util.Arrays;

public class TestBubble {
	//冒泡算法
	public static void test1() {
		int n = 1;
		int[] a = {2,12,4,56,1,5,11};
		for (int j = 0; j < a.length; j++) {
			//a.length-1-j  -1是避免i+1下标越界 -j是为了提升比较效率，不需要再和比较出来的数进行比较
			for (int i = 0; i < a.length-1-j; i++) { 
				int tmp = 0;
				if (a[i]>a[i+1]) {
					tmp = a[i];
					a[i] = a[i+1];
					a[i+1] = tmp;
				}
				System.out.println(n); //测试运行了多少次循环
				n++;
			}
		}	
		System.out.println(Arrays.toString(a)); 
	}
	//冒泡算法优化
	public static void test2() {
		int n = 1;
		int[] a = {1,0,2,5,6,7,11};
		for (int j = 0; j < a.length; j++) {
			//定义布尔标识
			boolean flag=true;
			//a.length-1-j  -1是避免i+1下标越界 -j是为了提升比较效率，不需要再和比较出来的数进行比较
			for (int i = 0; i < a.length-1-j; i++) { 
				int tmp = 0;
				if (a[i]>a[i+1]) {
					tmp = a[i];
					a[i] = a[i+1];
					a[i+1] = tmp;
					flag = false; //只要执行了值的交换，falg的值就是false，外层循环还会继执行
				} 
				System.out.println(n); //测试运行了多少次循环
				n++;
			}
			//如果内层循环没有进行值的交换，说明数列已经排好序，直接退出循环
			if (flag) {
				break;
			}
		}	
		System.out.println(Arrays.toString(a)); 
	}
	
	public static void main(String[] args) {
		test1();
		test2();
	}
}
