package net;
/**
 * 测试URL类常用方法
 * 写一个简单的爬虫，将页面内容写入文件
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
	//测试URL类的常用方法
	public void testURL() throws MalformedURLException {
		URL u1 = new URL("http://music.migu.cn/v3/music/playlist/147915731?page=1");
		System.out.println(u1.getDefaultPort());//获取默认端口
		System.out.println(u1.getFile());//端口后的内容
		System.out.println(u1.getHost());//后去域名
		System.out.println(u1.getPath());//获取端口后，参数前的文件路径
		System.out.println(u1.getPort());//判断为music.migu.cn:80返回80，否则-1
		System.out.println(u1.getProtocol());//获取网络协议
		System.out.println(u1.getQuery());//获取参数部分内容
		System.out.println(u1.getRef());//获取锚点
		URL u2 = new URL("http://music.migu.cn");
		URL u3 = new URL(u2, "/v3/music/playlist/147915731?page=1");//拼接URL方式构建对象
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
			OutputStreamWriter osw = new OutputStreamWriter(fos);//字节流转为字符流
			bw = new BufferedWriter(osw);
			while ((s=br.readLine())!=null) {
				bw.write(s);//页面内容逐行写进文件，方便后面有需要再过滤分析
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
					System.out.println("bw关闭");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (br!=null) {
					br.close();
					System.out.println("br关闭");
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
