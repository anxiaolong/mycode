package java_08_io;
/**
 * �����ļ��ַ���FileReader��FileWriter
 * ��Ҫע�⣺������ر��������޷�����д�룬ֻ�����ڴ滺����д����
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
				//��һ������Ϊ�ַ����飬�ڶ���Ϊ�ӵڼ����ַ���ʼд����������д���ַ���ascii��
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
