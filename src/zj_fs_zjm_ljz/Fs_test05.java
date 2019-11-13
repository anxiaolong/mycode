package zj_fs_zjm_ljz;
/**
 * 使用反射调用方法，去掉访问安全检查后，执行效率比普通调用差3倍
 */
import java.lang.reflect.Method;

public class Fs_test05 {
	public static void test1() {
		//普通调用getName方法
		Fs_User user = new Fs_User();
		Long startTime = System.currentTimeMillis();
		for (int i = 0; i < 1000000000L; i++) {
			user.getName();
		}
		Long endTime = System.currentTimeMillis();
		System.out.println("普通调用用时："+(endTime-startTime));
	}
	
	public static void test2() {
		//反射api调用getName方法
		Class<?> clz = Fs_User.class;
		try {
			Fs_User user = (Fs_User) clz.getConstructor().newInstance();
			Method m = clz.getMethod("getName", null);
			Long startTime = System.currentTimeMillis();
			for (int i = 0; i < 1000000000L; i++) {
				m.invoke(user, null);
			}
			Long endTime = System.currentTimeMillis();
			System.out.println("反射调用用时："+(endTime-startTime));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void test3() {
		//反射api调用getName方法,不执行安全访问检查
		Class<?> clz = Fs_User.class;
		try {
			Fs_User user = (Fs_User) clz.getConstructor().newInstance();
			Method m = clz.getMethod("getName", null);
			m.setAccessible(true);
			Long startTime = System.currentTimeMillis();
			for (int i = 0; i < 1000000000L; i++) {
				m.invoke(user, null);
			}
			Long endTime = System.currentTimeMillis();
			System.out.println("不执行安全检查用时："+(endTime-startTime));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void main(String[] args) {
		test1();
		test2();
		test3();
	}
}
