package java_14_regex;
/**
 * ���Ա��ʽ��ʹ�ò���������
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test02 {
	public static void main(String[] args) {
		Pattern p = Pattern.compile("([a-z]+)([0-9]+)");
		
		Matcher m = p.matcher("dfdf343*ijn009&&fdf90**");
		
		while (m.find()) {
			//group()��group(0)�������ս��
			//group(1)��group(2)��������������Ľ��
			System.out.println(m.group(0));
			System.out.println(m.group(1));
			System.out.println(m.group(2));
		}
	}
}
