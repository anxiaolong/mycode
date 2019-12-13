package regex;
/**
 * ²âÊÔÕıÔòÆ¥ÅäºóÌæ»»×Ö·û²Ù×÷
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test03 {
	public static void main(String[] args) {
		Pattern p = Pattern.compile("[0-9]");
		Matcher m = p.matcher("&1232*&*98*£¨*&*898");
		
//		String newStr = m.replaceAll("?");
		String newStr = m.replaceFirst("?");
		
		
		System.out.println(newStr);
	}
}
