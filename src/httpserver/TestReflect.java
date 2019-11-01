package httpserver;
/**
 * 测试Java反射，重点掌握Class.forName("包名.类名")
 */
import java.lang.reflect.InvocationTargetException;

public class TestReflect {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, NoSuchMethodException, SecurityException, InvocationTargetException {
		//普通创建对象方法
		Iphone iPhone5 = new Iphone();
		//1.通过 对象.getClass() 获取类
		Class clz = iPhone5.getClass();
		//2.通过类.class方式创建Class对象
		Class clz2 = Iphone.class;
		//3、Class.forName("包名.类名")
		Class clz3 = Class.forName("httpserver.Iphone");
		//通过Class对象创建对象
		Iphone iphone6 =(Iphone)clz.getConstructor().newInstance();
		Iphone iphone7 =(Iphone)clz2.getConstructor().newInstance();
		Iphone iphone8 =(Iphone)clz3.getConstructor().newInstance();
		System.out.println(iphone6);
		System.out.println(iphone7);
		System.out.println(iphone8);
	}
}

class Iphone {
	public Iphone() {
		// TODO Auto-generated constructor stub
	}
}