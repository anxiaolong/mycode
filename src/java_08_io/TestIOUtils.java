package java_08_io;
/**
 * ����IOUtils�࣬��Ҫ��������в���
 * FileUtils�࣬��Ҫ����ļ����в���
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.commons.io.IOUtils;

public class TestIOUtils {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		String s1 = IOUtils.toString(new FileInputStream("D:\\eclipse-workspace\\mycode\\src\\io\\test.txt"), "gbk");
		System.out.println(s1);
	}
}
