package java_12_zj_fs_zjm_ljz;
/**
 * 解密的过程在加载过程中处理
 */
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Ljz_DecryptClassLoader extends ClassLoader {
	//d:/myjava/  com/bjsxt/test/User.class
	private String rootDir;
	
	public Ljz_DecryptClassLoader(String rootDir) {
		this.rootDir = rootDir;
	}
	
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		Class<?> c = findLoadedClass(name);
		
		//判断是否已经加载了这个类，如果已经加载，直接返回。如果没有加载新的类
		if (c!=null) {
			return c;
		} else {
			ClassLoader parent = this.getParent();
			try {
				c = parent.loadClass(name);
			} catch (Exception e) {
				// TODO: handle exception
			}
			if (c!=null) {
				return c;
			} else {
				byte[] classData = getClassData(name);
				if (classData==null) {
					throw new ClassNotFoundException();
				}else {
					String[] strings = name.split(".");
					for (String string : strings) {
						System.out.println(string);
					}
					c = defineClass(name, classData, 0, classData.length);
				}
			}
		}
		return c;
	}
	
	private byte[] getClassData(String classname) {
		String path = rootDir +"/"+classname.replace('.', '/')+".class";

		InputStream is = null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			is = new FileInputStream(path);
			
			int temp = -1;
			while ((temp=is.read())!=-1) {
				baos.write(temp^0xff);//在此进行取反，相当于解密
			}
			
			return baos.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (is!=null) {
					is.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (baos!=null) {
					baos.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}












