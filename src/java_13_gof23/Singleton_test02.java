package java_13_gof23;
/**
 * 测试懒汉式单例模式
 * @author Administrator
 *
 */
public class Singleton_test02 {
	//初始化过程中，不会new对象
	private static Singleton_test02 instance;
	
	private Singleton_test02() {} //私有化构造器
	
	//真正使用时候才new对象，因为方法有线程同步，调用效率低
	public static synchronized Singleton_test02 getInstance() {
		if (instance==null) {
			instance = new Singleton_test02();
		}
		return instance;
	}
}
