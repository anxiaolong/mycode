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
			System.out.println("c:/test/"+" ·��û�н���");
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
			System.out.println("����openStream()����");
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
		System.out.println("��Ӧʱ�䣺"+(end-start)+"ms");
		return rsp.statusCode()+"-->"+(end-start)+"ms";
	}
	
	//��miguUrl�д����乾������
	public static void urlTolist(String url) {
		//������url��ַ
		String destStr = getURLContent(url,"utf-8");
		//��ȡԴ�����������
		List<String> result = getMatherSubstrs(destStr, "href=\"([\\w\\s./:]+?)\"");
		
		//���Ӳ�ȫ��������
		for (String temp : result) {
			if (temp.startsWith("//")) {
				String newString = "http:"+temp;
				miguUrl.add(newString);
				System.out.println("��ȡ��"+newString);
			} else if (temp.startsWith("/")) {
				String newString = "http://music.migu.cn"+temp;
				miguUrl.add(newString);
				System.out.println("��ȡ��"+newString);
			} else {
				miguUrl.add(temp);
				System.out.println("��ȡ��"+temp);
			}
		}
	}
	
	public static void nextLevel(int depth) throws InterruptedException {
		System.out.println("��ʼ����������ȡ");
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
					System.out.println("get��ַ��"+string);
					try {
						bw.write((new Date())+"-->get���-->"+getUrl(string)+"-->url-->"+string+"\r\n");
						bw.flush();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						pw.write((new Date())+"-->"+string+"\r\n");
						e.printStackTrace(pw);
						pw.write("#######################�ֽ�#########################################"+"\r\n");
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
						System.out.println(Thread.currentThread().getName()+" get��ַ��"+string);
						try {
							bw.write((new Date())+"-->get���-->"+getUrl(string)+"-->url-->"+string+"\r\n");
							bw.flush();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							pw.write((new Date())+"-->"+string+"\r\n");
							e.printStackTrace(pw);
							pw.write("#######################�ֽ�#########################################"+"\r\n");
							pw.flush();
						} 
						latch.countDown();
					}
				});
		}
		
		latch.await();
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println("���������1����������(�����٣�ʱ���)  2���������Ӽ����¼�����(�����࣬ʱ����)");
		Scanner scanner = new Scanner(System.in);
		int test1 = scanner.nextInt();
		System.out.println("������"+test1);
		System.out.println("�������Ƿ���߳�ִ�У�1���߳� 2���߳�");
		int test2 = scanner.nextInt();
		scanner.close();
		System.out.println(test2+"��ʼִ��");
		
		
		urlTolist("http://music.migu.cn/v3");
		if (test1==2) {
			nextLevel(1);
		}
		
		if (test2==1) {
			singleThreadRun();
		}else if (test2==2) {
			allThreadRun();
		} 
		
		System.out.println(miguUrl.size()+"������");
	}
}