package cy_class;
/**
 * 包装类测试
 * @author Administrator
 *
 */

public class TestBzl  {
	//装箱拆箱具体过程
	public static void test1() {
		Integer a = new Integer(10);
		Double b = Double.valueOf(3.22);
		//装箱
		Integer c = Integer.valueOf(33); //推荐调用valueof方法创建包装类对象，-128~127之间的值会进行缓存处理，可提高效率
		Integer d = 33; //编译通过，是因为编译器自动装箱，执行了valueOf方法
		//拆箱
		int e = a.intValue(); //拆箱的过程就是对象调用intValue方法
//		System.out.println(a);
//		System.out.println(b);
//		System.out.println(d);
//		System.out.println(e);
		//字符串转化为Integer对象
		Integer s = Integer.parseInt("6666"); //字符串里面的内容是数字，否则异常
		Integer s1 = new Integer("345"); //字符串里面的内容是数字，否则异常
//		System.out.println(s1);
//		System.out.println(s);
		//Integer对象转字符串
		String mString = s.toString();
		System.out.println(mString);
		//int类型相关常量
		System.out.println(Integer.MAX_VALUE+" "+Integer.MIN_VALUE);
	}
	//自动装箱和拆箱
	public static void test2() {
		Integer a = 24; //自动装箱成了一个对象
		int b = Integer.valueOf(33); //自动拆箱成int型数字
		int c = new Integer(45); //自动拆箱成int
		Integer d = null;
//		int e = d; //空指针是因为d调用了 d.intValue(),d为null，没有指向对象，所以报错
	}
	//包装类的缓存
	public static void test3() {
//	    public static Integer valueOf(int i) {
//        if (i >= IntegerCache.low && i <= IntegerCache.high)
//            return IntegerCache.cache[i + (-IntegerCache.low)];
//        return new Integer(i);
//    }
		Integer a = -128;
		Integer b = -128;
		System.out.println(a==b);
		System.out.println(a.equals(b));
		Integer a1 = -129;
		Integer b1 = -129;
		System.out.println(a1==b1); //-129不在缓存中，对象都是新建的
		System.out.println(a1.equals(b1)); //对象的值相同
	}
		public static void main(String[] args) {
			test1();
			test2();
			test3();
		}
}
