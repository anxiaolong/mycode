package httpserver;
/**
 * ��װ����request
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

//1.��װ����method url queryStr
//2.���������ת��Ϊmap
public class D3Request {
	//ȫ��������Ϣ
	private String requestInfo;
	//����ʽ
	private String method;
	//����url
	private String url;
	//�������
	private List<String> queryStr;
	public String getRequestInfo() {
		return requestInfo;
	}
	//����map
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
	
	//����������Ϣ
	public void parseRequestInfo() {
		//1.��ȡ����ʽ����ͷ��ʼ����һ���ո����
		method = requestInfo.substring(0, requestInfo.indexOf(blank));
		//2.��ȡ����URL����һ��/��HTTP/֮�䣬��ȥ�ո�
		int beginIndex = requestInfo.indexOf("/");
		int endIndex = requestInfo.indexOf("HTTP/");
		url = requestInfo.substring(beginIndex, endIndex).trim();
		//1)����url���в��������
		int index = url.indexOf("?");
		if (index>0) {//˵���в���
			String[] strings = url.split("\\?");//ʹ�÷��ŷָ���Ҫ��ת���ַ�
			//3.��ȡ���������get��post���п����ٵ�ַ��������
			queryStr.add(strings[1]);
			url = strings[0];
		}
		//�����post���󣬲���������body��
		if (method.equals("POST")) {
			String postString = requestInfo.substring(requestInfo.lastIndexOf(crlf)).trim();
			if (!postString.isEmpty()) {
				queryStr.add(postString);
			}
		}
		System.out.println(method+"-->"+url+"-->"+queryStr);
	}
	
	//������תΪmap
	public void coverMap() {
		parameterMap = new HashMap<String, List<String>>();
		for (String string : queryStr) {
			String[] s1 = string.split("&");
			for (String string2 : s1) {
				String[] s2 = string2.split("=");
				//�ָ��=����Ϊ�ռ���null
				s2 = Arrays.copyOf(s2, 2);
				//��ȡkey��value
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
		//�鿴��map,����map��ת��Ϊset
		Set<Entry<String,List<String>>> set1 = parameterMap.entrySet();
		for (Entry<String, List<String>> entry : set1) {
			System.out.println(entry);
		}
	}
	//�������Ϊ�������
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
		return "�ο�";
	}
}


