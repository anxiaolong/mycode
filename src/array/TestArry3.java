package array;
/**
 * 测试Arrays类下常用方法
 */
import java.util.Arrays;

public class TestArry3 {
	//打印数组
	public static void test1() {
		String[] s = {"see","ggg","eef"};
		System.out.println(Arrays.toString(s)); //Arrays类的toString方法打印数组
	}
	//排序sort方法，基本类型排序
	public static void test2() {
		int[] i = {34,33,5,55,31,23,3};
		Arrays.sort(i); //从小到大排序
		System.out.println(Arrays.toString(i));
		String[] strings = {"rdd","ref","bdg","tyujj"};
		Arrays.sort(strings);
		System.out.println(Arrays.toString(strings));
	}
	//对象排序
	public static void test3() {
		Man[] m = {new Man(32),new Man(12),new Man(18)};
		System.out.println(Arrays.toString(m));
		Arrays.sort(m);
		System.out.println(Arrays.toString(m));
	}
	//折半查找 先排序 再使用Arrays.binarySearch方法
	public static void test4() {
		int[] a = {2,45,55,3,45,78,23,34,21};
		Arrays.sort(a); //折半查找需要先对数组排序
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.binarySearch(a, 66)); //找不到情况返回负数
	}
	//数组填充方法fill
	public static void test5() {
		String[] strings = {"dgeg","hhh","erwf","tff"};
		Arrays.fill(strings, 0,1,"anxiaolong"); //下标为【0，1）替换为新字符串
		System.out.println(Arrays.toString(strings));
	}
	public static void main(String[] args) {
		test1();
		test2();
		test3();
		test4();
		test5();
	} 
}

//对象要排序需要实现Comparable接口
class Man implements Comparable { 
	int age;
	String name;
	
	public Man(int age) {
		this.age = age;
	}
	
	@Override
	public int compareTo(Object o) {
		Man man = (Man)o;
		if (this.age>man.age) {
			return 1; //返回值1或-1 影响排序的方式，从小到大或从大到小
		} else if (this.age<man.age) {
			return -1;
		}
		return 0;
	}
}


