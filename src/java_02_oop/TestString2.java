package java_02_oop;
/**
 * �ַ������ò�������
 * @author Administrator
 *
 */
public class TestString2 {
	public static void main(String[] args) {
		String s = "anxiaolong";
		String s1 = "Anxiaolong";
		String s2 = "an xiaolong";
		System.out.println(s.charAt(3)); //s[3]��ʲô��ĸ
		System.out.println(s.length()); //�����ַ������ȣ����Ǵ�0��ʼ����
		System.out.println(s.equals(s1));
		System.out.println(s.equals(s2)); //�Ƚ������ַ����Ƿ���ͬ
		System.out.println(s.equalsIgnoreCase(s1)); //��Ű��Сд���бȽ�
		System.out.println(s.indexOf("an")); //�����ַ���Ϊ0��������-1
		System.out.println(s.indexOf('w')); //�����ַ��жϷ���������ֵ0��-1
		String s3 = s2.replace(' ', '&'); //�ַ��滻	
		System.out.println(s3);
		System.out.println(s.startsWith("an")); //�Ƿ���an��ͷ
		System.out.println(s.endsWith("long")); //�Ƿ���long��β
		System.out.println(s.substring(3)); //��s[3]��ʼ����β����ȡ�ַ���
		System.out.println(s.substring(3, 5)); //��ȡs[4]-s[4]�ַ���
		System.out.println(s1.toLowerCase()); //ȫ��תСд
		System.out.println(s1.toUpperCase()); //ȫ��ת��д
		String s4 = "  an xiao long  ";
		System.out.println(s4.trim()); //ȥ���ַ���ǰ��ո�
		System.out.println(s4); //�ַ�����Щ���������ϲ���ı䶨��ĺõ��ַ������ַ������ɸı�
		
		
	}
}	
