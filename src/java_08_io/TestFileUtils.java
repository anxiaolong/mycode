package java_08_io;
/**
 * ���Թ�����FileUtils�����ļ��ķ���
 * ��ȡ�ļ��������ļ�������
 */
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class TestFileUtils {
	public static void main(String[] args) throws IOException {
		String s1 = FileUtils.readFileToString(new File("D:\\eclipse-workspace\\mycode\\src\\io\\test.txt"), "gbk");
		System.out.println(s1);
		FileUtils.copyDirectory(new File("D:\\java���\\commons-io-2.6-bin\\commons-io-2.6"), new File("D:\\java���\\test"), new FileFilter() {
			
			@Override
			public boolean accept(File pathname) {
				//���˹��̻�ȥ�����ļ�������������ļ�������true�Ϳ���������false�Ͳ�����
				if (pathname.isDirectory()||pathname.getName().endsWith("jar")) {//�����ļ��к�jar����������Ҫ
					return true;
				}else {
					return false;
				}
			}
		});
	}
}
