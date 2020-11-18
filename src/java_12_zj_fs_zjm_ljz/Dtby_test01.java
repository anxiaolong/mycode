package java_12_zj_fs_zjm_ljz;
/**
 * ����JavaCompiler��̬���룬URLClassLoader��̬������
 */
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

public class Dtby_test01 {
	public static void main(String[] args) {
//		String str = "public class Hi {public static void main(String[] args){System.out.println(\"HaHa,sxt!\");}}";
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		//��Ҫ��jdk/lib�����tool.jar������jre/lib�£����򱨿�ָ��
		int result = compiler.run(null, null, null,"D:\\eclipse-workspace\\mycode\\src\\zj_fs_zjm_ljz\\Dtby_HelloWorld.java");
		System.out.println(result==0?"����ɹ�":"����ʧ��");
		
		try {
			URL[] urls = new URL[] {new URL("File:/"+"D:/eclipse-workspace/mycode/bin/zj_fs_zjm_ljz/Dtby_HelloWorld.class")};
			URLClassLoader loader = new URLClassLoader(urls);
			for (URL url : urls) {
				System.out.println(url);
			}
			Class c = loader.loadClass("zj_fs_zjm_ljz.Dtby_HelloWorld");
			//���ü������main����
			Method m = c.getMethod("main", String[].class);
			//��ǿת�Ļ���������:m.invoke(null,"aa","bb"),�ͷ����˲���������ƥ�������
			m.invoke(null, (Object)new String[]{});
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
