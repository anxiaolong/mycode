package api_test;
/**
 * 相似歌曲测试脚本
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;

public class SimilarSongs {

	public static void main(String[] args) {
		System.out.println("开始执行测试。。。。。");
		try {
			//获取歌曲id
			FileInputStream fis = new FileInputStream(new File("c:/test/songID.txt"));
			FileOutputStream fos = new FileOutputStream(new File("c:/test/SimilarResult.txt"));
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
			int caseCount = 1;
			while (br.readLine()!=null) {
				String id = br.readLine();
				bw.write("case"+caseCount+"-->请求id:"+id+"\r\n");
				bw.write("源歌曲信息："+getSongInfo(id)+"\r\n\r\n");
				
				String SimilarSongsId = getSimilarSongs(id);
				Pattern p = Pattern.compile("[\\d]{18}");
				Matcher m = p.matcher(SimilarSongsId);
		
				int resultCount= 1;
				while (m.find()) {
					bw.write("匹配结果"+resultCount+"歌曲id："+m.group()+"\r\n");
					bw.write("匹配歌曲信息："+getSongInfo(m.group())+"\r\n");
					bw.write("-------------------------------------------------"+"\r\n");
					resultCount++;
				}
				
				bw.write("case"+caseCount+"执行完"+"###############################################\r\n"+"\r\n");
				bw.flush();
				caseCount++;
			}
			
			try {
				if (bw!=null) {
					bw.close();
				}
				if (br!=null) {
					br.close();
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("执行完成");
	}
	
	public static String getSimilarSongs(String songid) throws IOException {
		Connection conn = Jsoup.connect("https://open.migu.cn:98/sportMusic/1.0/rest/recommend/alike/music?evident")
				.method(Method.POST).ignoreContentType(true)
				.header("Authorization", "OEPAUTH chCode=\"a39d713b25e95b2b\", smartDeviceId=\"11c8478c000068\"")
				.header("Content-Type", "application/json")
				.requestBody("{\"musicId\":\""+songid+"\"}");
		Response rsp = conn.execute();
		return (rsp.statusCode() + " -> " + rsp.body());
	}
	
	public static String getSongInfo(String songid) throws IOException {
		Connection conn = Jsoup.connect("https://open.migu.cn:98/sportMusic/2.0/rest/music/get?evident")
				.method(Method.POST).ignoreContentType(true)
				.header("Authorization", "OEPAUTH chCode=\"a39d713b25e95b2b\", smartDeviceId=\"11c8478c000068\"")
				.header("Content-Type", "application/json")
				.requestBody("{\"musicId\":\""+songid+"\"}");
		Response rsp = conn.execute();
		return (rsp.statusCode() + " -> " + rsp.body());
	}
}
