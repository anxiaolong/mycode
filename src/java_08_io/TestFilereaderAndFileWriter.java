package java_08_io;
/**
 * 测试文件字符流FileReader、FileWriter
 * 需要注意：如果不关闭流，就无法正常写入，只是再内存缓存中写入了
 */
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TestFilereaderAndFileWriter {
	public static void test1(String src,String des) {
		System.out.println(src+"\n"+des);
		FileReader srcFileReader = null;
		FileWriter desFileWriter = null;
		try {
			srcFileReader = new FileReader(src);
			desFileWriter = new FileWriter(des);
			char[] tt = new char[1024];
			int temp = 0;
			while ((temp=srcFileReader.read(tt))!=-1) {
				//第一个参数为字符数组，第二个为从第几个字符开始写，第三个是写入字符的ascii码
				System.out.println(temp);
				desFileWriter.write(tt, 0, temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		finally {
			try {
				if (srcFileReader!=null) {
					srcFileReader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (desFileWriter!=null) {
					desFileWriter.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	public static void main(String[] args) {
		String srcString = "D:\\eclipse-workspace\\mycode\\src\\io\\test.txt";
		String deString = "D:\\eclipse-workspace\\mycode\\src\\io\\test_copy.txt";
		test1(srcString,deString);
	}
}
