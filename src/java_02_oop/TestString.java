package java_02_oop;
/**
 * String������
 * @author Administrator
 *
 */
public class TestString {
	public static void main(String[] args) {
		String str1 = "abc";
		String str2 = new String("def");
		String str3 = "abc";
		String str4 = str2.intern(); //inter()��str4����str2��Ӧ�Ķ�������str4��str2��ַ�ǲ�ͬ��
		String str5 = "def";
		// ==�ǱȽ��ַ��������õ�ַ
		System.out.println(str1 == str3);//��st3��ֵʱ��"abc"�Ѿ��ڳ������У�ֱ�ӷ������ĵ�ַ ������true
		System.out.println(str2 == str4);// inter()��str4����str2��Ӧ�Ķ�������str4��str2��ַ�ǲ�ͬ�� false
		System.out.println(str4 == str5);//���������Ѵ���ָ��def�Ķ���ֱ�ӷ��� true	
		System.out.println(str4.equals(str5)); //string.equals�ǱȽ��ַ����Ķ���ֵ������δtrue
		System.out.println(str2.equals(str4));
	}
}
