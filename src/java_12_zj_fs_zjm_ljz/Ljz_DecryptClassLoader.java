package java_12_zj_fs_zjm_ljz;
/**
 * ���ܵĹ����ڼ��ع����д���
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
		
		//�ж��Ƿ��Ѿ�����������࣬����Ѿ����أ�ֱ�ӷ��ء����û�м����µ���
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
				baos.write(temp^0xff);//�ڴ˽���ȡ�����൱�ڽ���
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












