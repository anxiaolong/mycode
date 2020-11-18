package java_14_regex;
/**
 * 测试匹配网页所有的链接
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test05 {
	public static void main(String[] args) throws Exception {
		Pattern p = Pattern.compile("href=\"(.*?)\"");
		URL url = new URL("http://music.migu.cn/v3");
		BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
		StringBuilder sb = new StringBuilder();
		while (br.readLine()!=null) {
			sb.append(br.readLine());
		}
		
		Matcher m = p.matcher(sb.toString());
		while (m.find()) {
			System.out.println(m.group());
		}
	}
}
