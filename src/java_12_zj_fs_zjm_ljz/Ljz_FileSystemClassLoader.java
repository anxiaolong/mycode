package java_12_zj_fs_zjm_ljz;
/**
 * 自定义文件系统类加载器
 */
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Ljz_FileSystemClassLoader extends ClassLoader {
	//d:/myjava/  com/bjsxt/test/User.class
	private String rootDir;
	
	public Ljz_FileSystemClassLoader(String rootDir) {
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
			
			byte[] buffer = new byte[1024];
			int temp = 0;
			while ((temp=is.read(buffer))!=-1) {
				baos.write(buffer, 0, temp);
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












