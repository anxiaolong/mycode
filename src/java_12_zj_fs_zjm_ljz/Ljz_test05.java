package java_12_zj_fs_zjm_ljz;
/**
 * �����߳��������������
 * @author Administrator
 *
 */
public class Ljz_test05 {
	public static void main(String[] args) throws Exception {
		//Ӧ���������
		ClassLoader loader1 = Ljz_test05.class.getClassLoader();
		System.out.println(loader1);
		
		ClassLoader loader2 = Thread.currentThread().getContextClassLoader();
		System.out.println(loader2);
		
		//Ϊ��ǰ�߳������µļ�������������Ĭ�ϼ�����
		Thread.currentThread().setContextClassLoader(new Ljz_FileSystemClassLoader("c:/test"));
		System.out.println(Thread.currentThread().getContextClassLoader());
		
		Class<Ljz_test05> c = (Class<Ljz_test05>)Thread.currentThread().getContextClassLoader().loadClass("zj_fs_zjm_ljz.Ljz_test05");
		System.out.println(c);
		System.out.println(c.getClassLoader());
	}
}
