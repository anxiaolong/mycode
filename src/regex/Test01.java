package regex;
/**
 * ����������java�еĻ���ʹ��
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test01 {
	public static void main(String[] args) {
		Pattern p = Pattern.compile("\\w+");
		
		Matcher m = p.matcher("dffd78&&fdf");
//		m.find();
//		System.out.println(m.group());
//		
//		m.find();
//		System.out.println(m.group());
		while (m.find()) {
			//group(),group(0)ƥ���������ʽ�����ַ���
			System.out.println(m.group());
			System.out.println(m.group(0));
		}
		
	}
}
