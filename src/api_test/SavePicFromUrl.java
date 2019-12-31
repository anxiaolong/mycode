package api_test;
/**
 * ≤‚ ‘œ¬‘ÿÕ¯¬ÁÕº∆¨
 */
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class SavePicFromUrl {
	public static void main(String[] args) {
		FileOutputStream fos = null;
		InputStream is = null;
		try {
			URL url = new URL("http://cdnmusic.migu.cn/picture/2019/1229/2330/AMa8c37634b0f147948cf40ed5f3aeb72f.jpg");
			is = url.openStream();
			fos = new FileOutputStream(new File("c:/a.jpg"));
			byte[] data = new byte[1024*1024];
			int len = 0;
			while ((len=is.read(data))!=-1) {
				fos.write(data, 0, len);
			}	
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if (fos!=null) {
					fos.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (is!=null) {
					is.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
