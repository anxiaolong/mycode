package java_14_regex;
/**
 * 测试表达式中使用捕获组的情况
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test02 {
	public static void main(String[] args) {
		Pattern p = Pattern.compile("([a-z]+)([0-9]+)");
		
		Matcher m = p.matcher("dfdf343*ijn009&&fdf90**");
		
		while (m.find()) {
			//group()和group(0)代表最终结果
			//group(1)和group(2)代表两个捕获组的结果
			System.out.println(m.group(0));
			System.out.println(m.group(1));
			System.out.println(m.group(2));
		}
	}
}
