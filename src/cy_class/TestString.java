package cy_class;

public class TestString {
	//String是不可变对象
	public static void test1() {
		String a = "anxiaolong"; //String的对象是不可变的，用final修饰的
		String a1 = a.substring(0, 6);
		System.out.println(a1);
		//比较a和a1的哈希值，说明这是两个不同的对象，字符串a根本没有发生变化，新建了a1
		System.out.println(Integer.toHexString(a.hashCode()));
		System.out.println(Integer.toHexString(a1.hashCode()));
	}
	//String类常用方法
	public static void test2() {
		String a = "an" + "xiaolong";
		String a1 = "anxiaolong";
		System.out.println(a==a1);
		System.out.println(a.equals(a1)); //编译器自动优化a和a1指向同一个对象
		System.out.println(a.concat(" test")); //concat()用于连接字符串
		System.out.println(a.replace('a', 'A')); //replace()替换字符串
		System.out.println((a.concat("test ")).trim()); //trim()去掉字符串前后的空格
		System.out.println(a.startsWith("eee")); //判断字符串以是否以eee开头
		System.out.println(a.endsWith("long")); //判断字符串是否以long结尾
		System.out.println(a.indexOf('n')); //返回l是第几个,从左往右第一次出现l的位置
		System.out.println(a.lastIndexOf('n')); //从右往左，第一次出现n的位置
		System.out.println(a.charAt(3)); //返回字符串第三个字符
		System.out.println(a.equalsIgnoreCase(a1)); //忽略大小写比较
		System.out.println(a.compareTo(a1)); //逐个比较，返回字符ASCII差值
	}
	public static void main(String[] args) {
		test1();
		test2();
	}
}
