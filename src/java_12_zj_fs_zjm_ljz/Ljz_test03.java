package java_12_zj_fs_zjm_ljz;
/**
 * �����Զ��������Ljz_FileSystemClassLoader
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
		
		//ͬһ���࣬����ͬ�ļ��������أ�jvm��Ϊ�ǲ�ͬ����
		System.out.println(c1.hashCode());
		System.out.println(c2.hashCode());
		System.out.println(c3.hashCode());
		
		System.out.println(c4.getClassLoader());//�����������
		System.out.println(c5.getClassLoader());//ϵͳĬ���������
		System.out.println(c3.getClassLoader());//�Զ��������
	}
}
