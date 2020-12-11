package java_apply01_api_test;
/**
 * 使用Jsoup发送post请求
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;

public class JsoupTest {
	public static void main(String[] args) throws IOException {
		
		File data = new File("C:/test/data.info");
		FileInputStream fis = new FileInputStream(data);
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		File result = new File("C:/test/result.txt");
		FileOutputStream fos = new FileOutputStream(result);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
		
		while ((br.readLine())!=null) {
			String parameter = ((br.readLine()).trim()).substring(1, 19);
			System.out.println(parameter);
			Connection conn = Jsoup.connect("https://open.migu.cn:98/sportMusic/2.0/rest/music/get?evident")
					.method(Method.POST).ignoreContentType(true)
					.header("Authorization", "OEPAUTH chCode=\"e2bb16040025cc1b\", smartDeviceId=\"005910310005\"")
					.header("Content-Type", "application/json")
					.requestBody("{\"musicId\":\""+parameter+"\"}");
			Response rsp = conn.execute();
			System.out.println(rsp.statusCode() + " -> " + rsp.body());
			bw.write(parameter+"结果："+rsp.statusCode()+" "+rsp.body()+"\n");
			bw.flush();
		}
	}
}
