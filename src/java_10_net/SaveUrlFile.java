package java_10_net;
/**
 * 将一个URL资源保存到本地
 */
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class SaveUrlFile {
	public static void main(String[] args) throws IOException {
		URL u1 = new URL("http://cdnmusic.migu.cn/picture/2019/1029/0928/AM86cbbc02dcf74975a155a57bb592b7fc.jpg");
		InputStream is = u1.openStream();
		FileOutputStream fos = new FileOutputStream(new File("D:\\eclipse-workspace\\mycode\\src\\net\\URL.jpg"));
		int temp = 0;
		while ((temp=is.read())!=-1) {
			fos.write(temp);
		}
		fos.close();
	}
}
