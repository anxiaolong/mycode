package java_apply01_api_test;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;

public class RequestUtils {
	public static String postData(String url,String body,String header) throws IOException {
		Connection conn = Jsoup.connect(url)
				.method(Method.POST).ignoreContentType(true)
				.header("Authorization", header)
				.header("Content-Type", "application/json")
				.requestBody(body);
		Response rsp = conn.execute();
		return "²ÎÊý£º"+body+" -> "+rsp.statusCode() + " -> " + rsp.body();
	}
}
