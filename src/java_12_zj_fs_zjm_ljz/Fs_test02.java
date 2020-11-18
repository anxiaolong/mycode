package java_12_zj_fs_zjm_ljz;
/**
 * 测试通过反射获取类名、属性、方法、构造器
 */
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Fs_test02 {
	public static void main(String[] args) {
		String path = "zj_fs_zjm_ljz.Fs_User";
		try {
			Class<?> clz = Class.forName(path);
			
			//反射获取类的名字
			System.out.println(clz.getName());//包名+类名
			System.out.println(clz.getSimpleName());//获取类名
			
			
			//反射获取属性信息
//			Field[] fields = clz.getFields();//只能获取public修饰的属性
			Field[] fields = clz.getDeclaredFields();//获取所有属性
			for (Field field : fields) {
				System.out.println("属性："+field);
			}
			
			//反射获取类的方法信息
			Method[] methods = clz.getDeclaredMethods();
			for (Method method : methods) {
				System.out.println("方法："+method);
			}
			Method m1 = clz.getDeclaredMethod("getName", null);
			//有参数需要传递参数类型对应的class对象
			Method m2 = clz.getDeclaredMethod("setName", String.class);
			Method m3 = clz.getDeclaredMethod("setAge", int.class);
			System.out.println(m1);
			System.out.println(m2);
			System.out.println(m3);
			
			//获取构造器信息
			Constructor[] constructors = clz.getConstructors();
			for (Constructor constructor : constructors) {
				System.out.println(constructor);
			}
			//获取有参构造
			Constructor<?> constructor = clz.getConstructor(int.class,String.class,int.class);
			System.out.println(constructor);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
