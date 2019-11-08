package httpserver;
/**
 * 封装请求request
 */
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

//1.封装请求：method url queryStr
//2.将请求参数转化为map
public class D3Request {
	//全部请求信息
	private String requestInfo;
	//请求方式
	private String method;
	//请求url
	private String url;
	//请求参数
	private List<String> queryStr;
	public String getRequestInfo() {
		return requestInfo;
	}
	//参数map
	private Map<String, List<String>> parameterMap;
	
	public String getUrl() {
		return url;
	}
	private final String crlf = "\r\n";
	private final String blank = " ";
	
	public D3Request(Socket socket) {
		queryStr = new ArrayList<String>();
		try {
			InputStream is = socket.getInputStream();
			byte[] datas = new byte[1024*1024];
			int len = is.read(datas);
			requestInfo = new String(datas, 0, len);
//			System.out.println(requestInfo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		parseRequestInfo();
		coverMap();
	}
	
	//分析请求信息
	public void parseRequestInfo() {
		//1.获取请求方式：从头开始到第一个空格截至
		method = requestInfo.substring(0, requestInfo.indexOf(blank));
		//2.获取请求URL：第一个/和HTTP/之间，再去空格
		int beginIndex = requestInfo.indexOf("/");
		int endIndex = requestInfo.indexOf("HTTP/");
		url = requestInfo.substring(beginIndex, endIndex).trim();
		//1)处理url中有参数的情况
		int index = url.indexOf("?");
		if (index>0) {//说明有参数
			String[] strings = url.split("\\?");//使用符号分割需要加转移字符
			//3.获取请求参数：get和post都有可能再地址栏传参数
			queryStr.add(strings[1]);
			url = strings[0];
		}
		//如何是post请求，参数可能再body中
		if (method.equals("POST")) {
			String postString = requestInfo.substring(requestInfo.lastIndexOf(crlf)).trim();
			if (!postString.isEmpty()) {
				queryStr.add(postString);
			}
		}
		System.out.println(method+"-->"+url+"-->"+queryStr);
	}
	
	//将参数转为map
	public void coverMap() {
		parameterMap = new HashMap<String, List<String>>();
		for (String string : queryStr) {
			String[] s1 = string.split("&");
			for (String string2 : s1) {
				String[] s2 = string2.split("=");
				//分割后，=后面为空加上null
				s2 = Arrays.copyOf(s2, 2);
				//获取key和value
				String key = s2[0];
				String value = s2[1]==null?null:decode(s2[1], "utf-8");
				if (parameterMap.containsKey(s2[0])) {
					parameterMap.get(s2[0]).add(s2[1]);
				} else {
					parameterMap.put(s2[0], new ArrayList<String>());
					parameterMap.get(s2[0]).add(s2[1]);
				}
			}
		}
		//查看下map,遍历map先转化为set
		Set<Entry<String,List<String>>> set1 = parameterMap.entrySet();
		for (Entry<String, List<String>> entry : set1) {
			System.out.println(entry);
		}
	}
	//处理参数为中文情况
	public String decode(String s,String enc) {
		try {
			return java.net.URLDecoder.decode(s, enc);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public String getName() {
		List<String> name = parameterMap.get("name");
		for (String string : name) {
			return string;
		}
		return "游客";
	}
}


