package zj_fs_zjm_ljz;
/**
 * 测试类加载层次，双亲委托机制
 * @author Administrator
 *
 */
public class Ljz_test02 {
	public static void main(String[] args) {
		System.out.println(ClassLoader.getSystemClassLoader());
		System.out.println(ClassLoader.getSystemClassLoader().getParent());
		//JAVA_HOME/jre/lib/rt.jar 顶层加载器不是java实现，无法获取到
		System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());
		System.out.println(System.getProperty("java.class.path"));
		/**
		 * sun.misc.Launcher$AppClassLoader@73d16e93
		   sun.misc.Launcher$ExtClassLoader@15db9742
		 */
		
		System.out.println("#################");
		String string = "anxiaolong";
		System.out.println(string.getClass().getClassLoader());
		System.out.println(string);
	}
}
