package java_14_regex;
/**
 * 使用正则表达式，实现一个简单的爬虫
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;

public class MiguSpider {
	private static CopyOnWriteArrayList<String> miguUrl = new CopyOnWriteArrayList<String>();
	static {
		IgnoreCert.ingnoreCertificates();
	}
	public static String  getURLContent(String urlStr,String charset){
		StringBuilder sb = new StringBuilder();
		try {
			URL url = new URL(urlStr);
			BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(),Charset.forName(charset)));
			String temp = "";
			while((temp=reader.readLine())!=null){
				sb.append(temp);
			}
		} catch (Exception e) {
//			e.printStackTrace();
			System.out.println("链接openStream()出错");
		} 
		return sb.toString();
	}
	
	public static List<String> getMatherSubstrs(String destStr,String regexStr){
		Pattern p = Pattern.compile(regexStr);
		Matcher m = p.matcher(destStr);
		List<String> result = new ArrayList<String>();
		while(m.find()){
			result.add(m.group(1));
		}	
		return result;
	}
	
	public static int getUrl(String url) throws Exception {
		Connection conn = Jsoup.connect(url)
				.method(Method.GET).ignoreContentType(true);
		Response rsp = conn.execute();
		return rsp.statusCode();
	}
	
	//向miguUrl中存入咪咕的链接
	public static void urlTolist(String url) {
		//设置主url地址
		String destStr = getURLContent(url,"utf-8");
		//获取源码里面的链接
		List<String> result = getMatherSubstrs(destStr, "href=\"([\\w\\s./:]+?)\"");
		
		//链接补全，并存入新的list中
		List<String> link = new ArrayList<String>();
		for (String temp : result) {
			if (temp.startsWith("//")) {
				String newString = "http:"+temp;
				link.add(newString);
			} else if (temp.startsWith("/")) {
				String newString = "http://music.migu.cn"+temp;
				link.add(newString);
			} else {
				link.add(temp);
			}
		}
		
		//遍历link，存入miguUrl并去重
		for (String string : link) {
			if (!miguUrl.contains(string)) {
				miguUrl.add(string);
			}
		}
	}
	
	public static void nextLevel(int depth) {
		for (int i = 0; i < depth; i++) {
			for (String string : miguUrl) {
				if (string.startsWith("http://music.migu.cn")||string.contains("i.migu.cn")) {
					urlTolist(string);
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		urlTolist("http://music.migu.cn/v3");
		
		nextLevel(1);
		
		FileOutputStream fos = new FileOutputStream(new File("c:/test/getResult"));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
		PrintWriter pw = new PrintWriter(new File("c:/test/getError"));
		int count = 0;
		for (String string : miguUrl) {
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					try {
						bw.write("get结果-->"+getUrl(string)+"-->url-->"+string+"\r\n");
						bw.flush();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						pw.write(string+"\r\n");
						e.printStackTrace(pw);
						pw.write("#######################分界#########################################"+"\r\n");
						pw.flush();
					} 
				}
			}).start();
			count++;
		}
		System.out.println(count+"条数据");
		
	}
}
