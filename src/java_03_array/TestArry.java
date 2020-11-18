package java_03_array;
/**
 * 创建基本类型数组
 * 创建引用类型数组
 * 数组初始化和默认值
 */

public class TestArry {
	
	public int a,b;
	public TestArry(int a,int b) {
		this.a = a;
		this.b = b;
	}
	//创建基本类型数组
	public static void test1() {
		int[] a = null; //声明一个数组，初始化为空
		a = new int[10]; //给数组分配空间
//		System.out.println(a.length); //a的数组长度为10
		//向数组赋值
		for (int i = 0; i < a.length; i++) {
			a[i] = i;
			System.out.println(a[i]);
		}
	}
	
	//创建引用类型数组
	public static void test2() {
		TestArry[] test; //声明引用类型数组test,数组类型修饰用类名修饰
		test = new TestArry[10]; //给引用对象分配内存空间
		TestArry t1Arry = new TestArry(23,22);
		TestArry t2Arry = new TestArry(1,2);
		test[0] = t1Arry;
		test[1] = t2Arry;
		System.out.println(test[0]); //引用数组内存储的就是对象的地址
	}
	
	//数组初始化和默认值
	public static void test3() {
		int[] a  = {1,2,3}; //静态初始化基本类型数组
		TestArry[] a1 = {new TestArry(1, 1),new TestArry(3, 5)}; //静态初始化引用类型数组
		//动态初始化
		int[] a2 = new int[2]; //分配空间
		System.out.println(a2[0]); //默认值为0 
		System.out.println(a2[1]); 
		a2[0] = 1;
		a2[1] = 2;
		boolean[] a3 = new boolean[1];
		System.out.println(a3[0]); //boolean类型默认值为false
		String[] a4 = new String[1];
		System.out.println(a4[0]); //string类型默认值为null
		TestArry[] a5 = new TestArry[1];
		System.out.println(a5[0]); //引用类型默认值也为null
	}
	
	public static void main(String[] args) {
		test1();
		test2();
		test3();
	}
}
