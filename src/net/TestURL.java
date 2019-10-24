package net;
/**
 * ����URL�ೣ�÷���
 * дһ���򵥵����棬��ҳ������д���ļ�
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;

public class TestURL {
	//����URL��ĳ��÷���
	public void testURL() throws MalformedURLException {
		URL u1 = new URL("http://music.migu.cn/v3/music/playlist/147915731?page=1");
		System.out.println(u1.getDefaultPort());//��ȡĬ�϶˿�
		System.out.println(u1.getFile());//�˿ں������
		System.out.println(u1.getHost());//��ȥ����
		System.out.println(u1.getPath());//��ȡ�˿ں󣬲���ǰ���ļ�·��
		System.out.println(u1.getPort());//�ж�Ϊmusic.migu.cn:80����80������-1
		System.out.println(u1.getProtocol());//��ȡ����Э��
		System.out.println(u1.getQuery());//��ȡ������������
		System.out.println(u1.getRef());//��ȡê��
		URL u2 = new URL("http://music.migu.cn");
		URL u3 = new URL(u2, "/v3/music/playlist/147915731?page=1");//ƴ��URL��ʽ��������
		System.out.println(u3);
	}
	public static void basicSpider() throws MalformedURLException {
		URL url = new URL("http://music.migu.cn/v3");
		BufferedReader br = null;
		BufferedWriter bw = null;
		String s = "";
		try {
			InputStreamReader isr = new InputStreamReader(url.openStream());
			br = new BufferedReader(isr);
			FileOutputStream fos = new FileOutputStream("D:\\eclipse-workspace\\mycode\\src\\net\\test");
			OutputStreamWriter osw = new OutputStreamWriter(fos);//�ֽ���תΪ�ַ���
			bw = new BufferedWriter(osw);
			while ((s=br.readLine())!=null) {
				bw.write(s);//ҳ����������д���ļ��������������Ҫ�ٹ��˷���
				bw.newLine();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if (bw!=null) {
					bw.close();
					System.out.println("bw�ر�");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (br!=null) {
					br.close();
					System.out.println("br�ر�");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) throws MalformedURLException {
		basicSpider();
	}
}
