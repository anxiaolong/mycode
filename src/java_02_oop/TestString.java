package java_02_oop;
/**
 * String常量池
 * @author Administrator
 *
 */
public class TestString {
	public static void main(String[] args) {
		String str1 = "abc";
		String str2 = new String("def");
		String str3 = "abc";
		String str4 = str2.intern(); //inter()让str4共享str2对应的对象，所以str4和str2地址是不同的
		String str5 = "def";
		// ==是比较字符串的引用地址
		System.out.println(str1 == str3);//给st3赋值时候，"abc"已经在常量池中，直接返回它的地址 ，所以true
		System.out.println(str2 == str4);// inter()让str4共享str2对应的对象，所以str4和str2地址是不同的 false
		System.out.println(str4 == str5);//常量池中已存在指向def的对象，直接返回 true	
		System.out.println(str4.equals(str5)); //string.equals是比较字符串的对象值，所以未true
		System.out.println(str2.equals(str4));
	}
}
