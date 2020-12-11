package java_apply01_api_test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;

public class FastJsonFormatTool extends Object {
	
	public static String getReslut() throws IOException {
		Connection conn = Jsoup.connect("http://218.200.227.123:9921/sportMusic/1.0/rest/migu/app/rank/get?evident")
				.method(Method.POST).ignoreContentType(true)
				.header("Authorization", "OEPAUTH chCode=\"a39d713b25e95b2b\", smartDeviceId=\"11c8478c000068\"")
				.header("Content-Type", "application/json");
		Response rsp = conn.execute();
		return rsp.body();
	}
	public static void main(String[] args) throws Exception {
			
		FileWriter fw = new FileWriter(new File("c:/a.txt"));
		String result = getReslut();
		JSONObject object = JSONObject.parseObject("{\"list\":"+result+"}");
        String pretty = JSON.toJSONString(object, SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue, 
        SerializerFeature.WriteDateUseDateFormat);
        System.out.println(pretty);
		fw.write(pretty);
		fw.flush();
		fw.close();
	}
}
