package array;
/**
 * 使用循环操作数组
 * for-each读取数组中的内容
 * 数组拷贝方法：System.arraycopy(src, srcPos, dest, destPos, length); 
 * @author Administrator
 *
 */
public class TestArry2 {
	//循环遍历数组
	public static void test1() {
		int[] a = new int[8];
		for (int i = 0; i < a.length; i++) {
			a[i] = i;
		}
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
	//使用for-each遍历数组,只读取不操作数组
	public static void test2() {
		String[] a = {"ddd","iiff","ddkk"};
		for (String string : a) {
			System.out.println(string);
		}
	}
	//数组的拷贝
	public static void test3() {
		String a[] = {"rr","dd","bbb"};
		String[] b = new String[6];
		System.arraycopy(a, 0, b, 3, a.length); //length是源数组的长度
//		System.arraycopy(src, srcPos, dest, destPos, length);  
		/*srcPos:源数组从哪个下标开始复制  destPos：目标数组从哪个下标开始粘贴 length是源数组的长度*/
		for (String string : b) {
			System.out.println(string);
		}
	}
	public static void main(String[] args) {
		test1();
		test2();
		test3();
	}
}
