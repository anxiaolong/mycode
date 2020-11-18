package java_12_zj_fs_zjm_ljz;
/**
 * 使用反射构造对象，操作属性，调用方法
 */
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Fs_test03 {
	public static void main(String[] args) {
		String path = "zj_fs_zjm_ljz.Fs_User";
		
		try {
			Class<?> clz = Class.forName(path);
			
			//通过反射API调用构造方法，构造对象
			Fs_User user = (Fs_User)clz.newInstance();//相当于调用空构造
			System.out.println(user);
			
			Constructor<Fs_User> constructor = (Constructor<Fs_User>) clz.getConstructor(int.class,String.class,int.class);
			Fs_User user2 = constructor.newInstance(11,"anxiaolong",27);//获取有参构造，创建对象
			System.out.println(user2.getName());
			
			//通过反射API调用普通方法
			Method m1 = clz.getDeclaredMethod("setName", String.class);
			m1.invoke(user2, "testanxiaolong");//重新设置user2的变量
			System.out.println(user2.getName());
			
			//通过反射API直接操作属性
			Field f = clz.getDeclaredField("name");
			f.setAccessible(true);//跳过安全检查
			f.set(user2, "test0001");
			System.out.println(f.get(user2));//通过反射直接读取属性值
			System.out.println(user2.getName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
