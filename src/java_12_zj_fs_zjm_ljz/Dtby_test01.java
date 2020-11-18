package java_12_zj_fs_zjm_ljz;
/**
 * 测试JavaCompiler动态编译，URLClassLoader动态加载类
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
		//需要把jdk/lib下面的tool.jar拷贝到jre/lib下，否则报空指针
		int result = compiler.run(null, null, null,"D:\\eclipse-workspace\\mycode\\src\\zj_fs_zjm_ljz\\Dtby_HelloWorld.java");
		System.out.println(result==0?"编译成功":"编译失败");
		
		try {
			URL[] urls = new URL[] {new URL("File:/"+"D:/eclipse-workspace/mycode/bin/zj_fs_zjm_ljz/Dtby_HelloWorld.class")};
			URLClassLoader loader = new URLClassLoader(urls);
			for (URL url : urls) {
				System.out.println(url);
			}
			Class c = loader.loadClass("zj_fs_zjm_ljz.Dtby_HelloWorld");
			//调用加载类的main方法
			Method m = c.getMethod("main", String[].class);
			//不强转的话，会编译成:m.invoke(null,"aa","bb"),就发生了参数个数不匹配的问题
			m.invoke(null, (Object)new String[]{});
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
