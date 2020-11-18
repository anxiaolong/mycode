package java_12_zj_fs_zjm_ljz;
/**
 * 测试自定义加载器Ljz_FileSystemClassLoader
 * @author Administrator
 *
 */
public class Ljz_test03 {
	public static void main(String[] args) throws Exception {
		Ljz_FileSystemClassLoader loader1 = new Ljz_FileSystemClassLoader("C:/test");
		Ljz_FileSystemClassLoader loader2 = new Ljz_FileSystemClassLoader("C:/test");
		
		Class<?> c1 = loader1.loadClass("HelloWorld");
		Class<?> c2 = loader1.loadClass("HelloWorld");
		Class<?> c3 = loader2.loadClass("HelloWorld");
		
		Class<?> c4 = loader2.loadClass("java.lang.String");
		Class<?> c5 = loader2.loadClass("zj_fs_zjm_ljz.Ljz_test03");
		
		//同一个类，被不同的加载器加载，jvm认为是不同的类
		System.out.println(c1.hashCode());
		System.out.println(c2.hashCode());
		System.out.println(c3.hashCode());
		
		System.out.println(c4.getClassLoader());//引导类加载器
		System.out.println(c5.getClassLoader());//系统默认类加载器
		System.out.println(c3.getClassLoader());//自定义加载器
	}
}
