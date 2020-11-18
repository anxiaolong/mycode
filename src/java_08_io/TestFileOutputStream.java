package java_08_io;
/**
 * 测试文件字节流，FileInputStrem和FileOutputStream
 * 文件字节字节拷贝，write(byte b[], int off, int len)方法使用
 * 缓存数组的使用
 */
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestFileOutputStream {
	
	//测试字节流写入FileOutputStream
	public static void testOutput() {
		FileOutputStream out1 = null;
		 String s = "anxiaolong";
		 try {
			out1 = new FileOutputStream("D:\\eclipse-workspace\\mycode\\src\\io\\test.txt");
			out1.write(s.getBytes());//写入一个字节数组
		} catch (Exception e) {
			e.printStackTrace();
		}
		 finally {
			 try {
				 if (out1!=null) {
					 out1.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	//拷贝文件内容
	public static void testCopy(String src,String des) {
		FileInputStream srcFile = null;
		FileOutputStream desFile = null;
		byte[] data = new byte[1024];//新建一个缓存数组提升io性能，减少对硬盘的读写次数
		try {
			srcFile = new FileInputStream(src);
			desFile = new FileOutputStream(des);
			int temp = 0;
			while ((temp=srcFile.read(data))!=-1) {
//				desFile.write(temp);;//使用write(int b)方法直接写入效率较低
				desFile.write(data, 1, temp);//中间的off是从src第几个字节开始写
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (srcFile!=null) {
					srcFile.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (desFile!=null) {
					desFile.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		String srcString = "D:\\eclipse-workspace\\mycode\\src\\io\\test.txt";
		String deString = "D:\\eclipse-workspace\\mycode\\src\\io\\test_copy.txt";
		 testCopy(srcString,deString);
	}
}
