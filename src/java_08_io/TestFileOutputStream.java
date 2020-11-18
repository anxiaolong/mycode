package java_08_io;
/**
 * �����ļ��ֽ�����FileInputStrem��FileOutputStream
 * �ļ��ֽ��ֽڿ�����write(byte b[], int off, int len)����ʹ��
 * ���������ʹ��
 */
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestFileOutputStream {
	
	//�����ֽ���д��FileOutputStream
	public static void testOutput() {
		FileOutputStream out1 = null;
		 String s = "anxiaolong";
		 try {
			out1 = new FileOutputStream("D:\\eclipse-workspace\\mycode\\src\\io\\test.txt");
			out1.write(s.getBytes());//д��һ���ֽ�����
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
	
	//�����ļ�����
	public static void testCopy(String src,String des) {
		FileInputStream srcFile = null;
		FileOutputStream desFile = null;
		byte[] data = new byte[1024];//�½�һ��������������io���ܣ����ٶ�Ӳ�̵Ķ�д����
		try {
			srcFile = new FileInputStream(src);
			desFile = new FileOutputStream(des);
			int temp = 0;
			while ((temp=srcFile.read(data))!=-1) {
//				desFile.write(temp);;//ʹ��write(int b)����ֱ��д��Ч�ʽϵ�
				desFile.write(data, 1, temp);//�м��off�Ǵ�src�ڼ����ֽڿ�ʼд
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
