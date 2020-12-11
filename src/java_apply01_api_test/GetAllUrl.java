package java_apply01_api_test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;


public class GetAllUrl {
	public static CopyOnWriteArraySet<String> miguUrl = new CopyOnWriteArraySet<String>();
	public static SimpleDateFormat dateFormat;
	public static Date date;
	public static FileOutputStream fos;
	public static BufferedWriter bw;
	public static PrintWriter pw;
	static {
		dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		date = new Date();
		try {
			fos = new FileOutputStream(new File("c:/test/"+dateFormat.format(date)+"-getResult"));
			bw = new BufferedWriter(new OutputStreamWriter(fos));
			pw = new PrintWriter(new File("c:/test/"+dateFormat.format(date)+"-getError"));
		} catch (FileNotFoundException e) {
			System.out.println("c:/test/"+" 路径没有建好");
		}
	}
	
//	static {
//		IgnoreCertTest.ingnoreCertificates();
//	}
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
	
	public static String getUrl(String url) throws Exception {
		Connection conn = Jsoup.connect(url)
				.method(Method.GET).ignoreContentType(true);
		long start = System.currentTimeMillis();
		Response rsp = conn.execute();
		long end = System.currentTimeMillis();
		System.out.println("响应时间："+(end-start)+"ms");
		return rsp.statusCode()+"-->"+(end-start)+"ms";
	}
	
	//向miguUrl中存入咪咕的链接
	public static void urlTolist(String url) {
		//设置主url地址
		String destStr = getURLContent(url,"utf-8");
		//获取源码里面的链接
		List<String> result = getMatherSubstrs(destStr, "href=\"([\\w\\s./:]+?)\"");
		
		//链接补全，并存入
		for (String temp : result) {
			if (temp.startsWith("//")) {
				String newString = "http:"+temp;
				miguUrl.add(newString);
				System.out.println("爬取："+newString);
			} else if (temp.startsWith("/")) {
				String newString = "http://music.migu.cn"+temp;
				miguUrl.add(newString);
				System.out.println("爬取："+newString);
			} else {
				miguUrl.add(temp);
				System.out.println("爬取："+temp);
			}
		}
	}
	
	public static void nextLevel(int depth) throws InterruptedException {
		System.out.println("开始二级链接爬取");
		Thread.sleep(3000);
		for (int i = 0; i < depth; i++) {
			for (String string : miguUrl) {
				if (string.startsWith("http://music.migu.cn")) {
					urlTolist(string);
				}
			}
		}
	}
	
	public static void singleThreadRun() throws InterruptedException {
		CountDownLatch latch = new CountDownLatch(miguUrl.size());	
		ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
		
		for (String string : miguUrl) {
			singleThreadExecutor.execute(new Runnable() {
				@Override
				public void run() {
					System.out.println("get地址："+string);
					try {
						bw.write((new Date())+"-->get结果-->"+getUrl(string)+"-->url-->"+string+"\r\n");
						bw.flush();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						pw.write((new Date())+"-->"+string+"\r\n");
						e.printStackTrace(pw);
						pw.write("#######################分界#########################################"+"\r\n");
						pw.flush();
					} 
					latch.countDown();
				}
			});
		}
		latch.await();
	}
	
	public static void allThreadRun() throws InterruptedException {
		CountDownLatch latch = new CountDownLatch(miguUrl.size());
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
		
		for (String string : miguUrl) {
				fixedThreadPool.execute(new Runnable() {
					@Override
					public void run() {
						System.out.println(Thread.currentThread().getName()+" get地址："+string);
						try {
							bw.write((new Date())+"-->get结果-->"+getUrl(string)+"-->url-->"+string+"\r\n");
							bw.flush();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							pw.write((new Date())+"-->"+string+"\r\n");
							e.printStackTrace(pw);
							pw.write("#######################分界#########################################"+"\r\n");
							pw.flush();
						} 
						latch.countDown();
					}
				});
		}
		
		latch.await();
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println("请输入检查项：1主界面链接(数量少，时间快)  2主界面链接及其下级链接(数量多，时间慢)");
		Scanner scanner = new Scanner(System.in);
		int test1 = scanner.nextInt();
		System.out.println("测试项"+test1);
		System.out.println("请输入是否多线程执行：1单线程 2多线程");
		int test2 = scanner.nextInt();
		scanner.close();
		System.out.println(test2+"开始执行");
		
		
		urlTolist("http://music.migu.cn/v3");
		if (test1==2) {
			nextLevel(1);
		}
		
		if (test2==1) {
			singleThreadRun();
		}else if (test2==2) {
			allThreadRun();
		} 
		
		System.out.println(miguUrl.size()+"条数据");
	}
}