package java_14_regex;
/**
 * ����java��֧��������ʽ�ķ���
 * @author Administrator
 *
 */
public class Test04 {
	public static void main(String[] args) {
		String s = "dfd899ijij9090jjkj";
		String[] array = s.split("\\d+");
		for (String string : array) {
			System.out.println(string);
		}
	}
}
