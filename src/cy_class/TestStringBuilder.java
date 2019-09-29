package cy_class;
/**
 * 测试可变字符串类StringBuilder和StringBuffer的用法
 * 比较String和StringBuilder的操作性能
 * @author Administrator
 *
 */
public class TestStringBuilder {
	//可变字符串StringBuilder
	public static void test1() {
		StringBuilder a = new StringBuilder();
		for (int i = 0; i < 10; i++) {
			a.append((char)('a'+i));
		}
		System.out.println(a.toString()); //转换成字符串输出
		System.out.println(a.append(",test")); //追加字符串
		
		//测试StringBuffer
		StringBuffer a1 = new StringBuffer("anxiaolong");
		a1.insert(0, 'T').insert(1, 'G'); //插入字符
		System.out.println(a1);
		a1.delete(0, 2); //删除字符串
		System.out.println(a1);
		System.out.println(a1.deleteCharAt(0)); //删除某个位置字符
		System.out.println(a1.charAt(3)); //获取某个位置字符
		System.out.println(a1.reverse()); //字符串逆序
	}
	//String拼接字符串和StringBuilder性能对比
	public static void test2() {
		String aString = new String("anxiaolong");
		long m1 = Runtime.getRuntime().freeMemory();
//		System.out.println(m1);
		long t1 = System.currentTimeMillis();
//		System.out.println(t1);
		for (int i = 0; i < 1000; i++) {
			aString += i;
		}
		System.out.println(aString);
		long m2 = Runtime.getRuntime().freeMemory();
		long t2 = System.currentTimeMillis();
		System.out.println("消耗内存："+(m1-m2));
		System.out.println("消耗时间："+(t2-t1));
		
		StringBuffer aBuffer = new StringBuffer("anxiaolong");
		long m1_ = Runtime.getRuntime().freeMemory();
		long t1_ = System.currentTimeMillis();
		for (int i = 0; i < 1000; i++) {
			aBuffer.append(i);
		}
		System.out.println(aBuffer);
		long m2_ = Runtime.getRuntime().freeMemory();
		long t2_ = System.currentTimeMillis();
		System.out.println("消耗内存："+(m1_-m2_));
		System.out.println("消耗时间："+(t2_-t1_));
	}
	public static void main(String[] args) {
		test1();
		test2();
	}
		
}
