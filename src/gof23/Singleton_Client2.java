package gof23;
/**
 * 懒汉式单例模式如何防止反射和反序列化
 * 再构造器中判断，防止反射
 * 定义readResolve方式，直接返回对象，不再新建
 */
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

public class Singleton_Client2 {
	public static void main(String[] args) throws Exception {
		Singleton_test06 s1 = Singleton_test06.getInstance();
		Singleton_test06 s2 = Singleton_test06.getInstance();
		
		System.out.println(s1);
		System.out.println(s2);
		
		//测试通过反序列化方式构造多个对象
		FileOutputStream fos = new FileOutputStream("C:/test/a.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(s1);
		oos.close();
		fos.close();
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:/test/a.txt"));
		Singleton_test06 s3 = (Singleton_test06)ois.readObject();
		System.out.println(s3);
		
		//测试通过反射调用私有构造器
		Class<Singleton_test06> clz = (Class<Singleton_test06>) Class.forName("gof23.Singleton_test06");
		Constructor<Singleton_test06> c = clz.getDeclaredConstructor();
		c.setAccessible(true);
		Singleton_test06 s4 = c.newInstance();
		Singleton_test06 s5 = c.newInstance();
		
		System.out.println(s4);
		System.out.println(s5);
	}
}	
