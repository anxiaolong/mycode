package java_08_io;
/**
 * 测试工具类FileUtils操作文件的方法
 * 读取文件，拷贝文件并过滤
 */
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class TestFileUtils {
	public static void main(String[] args) throws IOException {
		String s1 = FileUtils.readFileToString(new File("D:\\eclipse-workspace\\mycode\\src\\io\\test.txt"), "gbk");
		System.out.println(s1);
		FileUtils.copyDirectory(new File("D:\\java相关\\commons-io-2.6-bin\\commons-io-2.6"), new File("D:\\java相关\\test"), new FileFilter() {
			
			@Override
			public boolean accept(File pathname) {
				//过滤过程会去遍历文件夹里面的所有文件，返回true就拷贝，返回false就不拷贝
				if (pathname.isDirectory()||pathname.getName().endsWith("jar")) {//拷贝文件夹和jar包，其他不要
					return true;
				}else {
					return false;
				}
			}
		});
	}
}
