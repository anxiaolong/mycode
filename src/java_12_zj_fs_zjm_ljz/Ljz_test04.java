package java_12_zj_fs_zjm_ljz;
/**
 * 测试类记载过程中取反加密和解密
 * @author Administrator
 *
 */
public class Ljz_test04 {
	public static void main(String[] args) throws Exception {
		Ljz_DecryptClassLoader loader = new Ljz_DecryptClassLoader("C:/test/temp");
		Class<?> c = loader.loadClass("HelloWorld");
		System.out.println(c);
	}
}
