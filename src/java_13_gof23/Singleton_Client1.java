package java_13_gof23;
/**
 * 测试几种单例模式的实现
 * @author Administrator
 *
 */
public class Singleton_Client1 {
	public static void main(String[] args) {
		Singleton_test02 s1 = Singleton_test02.getInstance();
		Singleton_test02 s2 = Singleton_test02.getInstance();
		
		//如果s1==s2,则单例模式实现成功
		System.out.println(s1);
		System.out.println(s2);
		
		//测试枚举单例模式实现
		System.out.println(Singleton_test05.instance==Singleton_test05.instance);
	}
}
