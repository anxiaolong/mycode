package java_13_gof23;
/**
 * 懒汉式单例模式如何防止反射和反序列化
 * 再构造器中判断，防止反射
 * 定义readResolve方式，直接返回对象，不再新建
 */
import java.io.ObjectStreamException;
import java.io.Serializable;

@SuppressWarnings("all")
public class Singleton_test06 implements Serializable {
	private static Singleton_test06 instance;
	
	private Singleton_test06() {
		//单例模式下调用构造器重新创建对象，直接抛出一个异常
		if (instance!=null) {
			throw new RuntimeException();
		}
	}
	
	public static synchronized Singleton_test06 getInstance() {
		if (instance==null) {
			instance = new Singleton_test06();
		}
		return instance;
	}
	
	//反序列化时，如果定义了readResolve方法，则直接返回此方法指定的对象，不需要再创建
	private Object readResolve() throws ObjectStreamException {
		return instance;
	}
	
}


