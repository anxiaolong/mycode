package array;
/**
 * 多维数组声明，初始化
 * 二维数组存储表格数据
 */
import java.util.Arrays;

public class TestArry4 {
	//二维数组声明
	private static void test1() {
		int[][] a = new int[3][]; 
		a[0] = new int[2];
		a[1] = new int[3];
		a[2] = new int[4];	
		System.out.println(Arrays.toString(a)); //数组a只有三个地址
	}
	//二维数组静态初始化
	public static void test2() {
		int[][] a = {{1,3,5},{2},{4,5}};
		System.out.println(a[0][2]);
//		System.out.println(Arrays.toString(a[1][])); //a[1][]可以在逻辑上理解为一个数组，但是不能使用array类的方法
		System.out.println(Arrays.toString(a[1]));
	}
	//二维数组动态初始化，一维二维数组长度获取
	public static void test3() {
		int[][] a = new int[3][];
		a[0] = new int[] {1,2};
		a[1] = new int[] {3,6,1};
		a[2] = new int[] {8};
		System.out.println(a[1][1]);
		System.out.println(Arrays.toString(a[1])); 
		System.out.println(Arrays.toString(a[2]));
		System.out.println(a.length); //一维数组长度
		System.out.println(a[1].length); //二维数组长度
	}
	//使用二维数组存储表格数据
	public static void test4() {
		Object[][] a = new Object[3][];
		a[0] = new Object[] {"anxiaolong",27,122,3.234};
		a[1] = new Object[] {345,"adec","deff","deff"};
		a[2] = new Object[] {"innif",23,"didgf",'c'};
		System.out.println(Arrays.toString(a[0]));
		System.out.println(Arrays.toString(a[1]));
		System.out.println(Arrays.toString(a[2]));
	}
	public static void main(String[] args) {
		test1();
		test2();
		test3();
		test4();
	}
}
