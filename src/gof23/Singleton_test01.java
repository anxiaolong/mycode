package gof23;
/**
 * 测试饿汉式单例模式
 * 单例模式：一个类只有一个对应的对象
 * @author Administrator
 *
 */
public class Singleton_test01 {
	//加载类的同时，将创建对象，缺点是没有懒加载
	public static Singleton_test01 instance = new Singleton_test01();
	
	private Singleton_test01() {}
	
	//调用效率高，没有线程同步
	public static Singleton_test01 getInstance() {
		return instance;
	}
}
