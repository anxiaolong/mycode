package java_13_gof23;
/**
 * 测试使用静态内部类实现单例模式
 * 优点：线程安全、调用效率高、实现了懒加载
 * @author Administrator
 *
 */
public class Singleton_test04 {
	private static class SingletonClassInstance {
		private static final Singleton_test04 instance = new Singleton_test04();
	}
	
	private Singleton_test04() {}
	
	//方法没有线程同步，调用效率高
	public static Singleton_test04 getInstance() {
		return SingletonClassInstance.instance;
	}
}
