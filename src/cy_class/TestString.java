package cy_class;

public class TestString {
	//String�ǲ��ɱ����
	public static void test1() {
		String a = "anxiaolong"; //String�Ķ����ǲ��ɱ�ģ���final���ε�
		String a1 = a.substring(0, 6);
		System.out.println(a1);
		//�Ƚ�a��a1�Ĺ�ϣֵ��˵������������ͬ�Ķ����ַ���a����û�з����仯���½���a1
		System.out.println(Integer.toHexString(a.hashCode()));
		System.out.println(Integer.toHexString(a1.hashCode()));
	}
	//String�ೣ�÷���
	public static void test2() {
		String a = "an" + "xiaolong";
		String a1 = "anxiaolong";
		System.out.println(a==a1);
		System.out.println(a.equals(a1)); //�������Զ��Ż�a��a1ָ��ͬһ������
		System.out.println(a.concat(" test")); //concat()���������ַ���
		System.out.println(a.replace('a', 'A')); //replace()�滻�ַ���
		System.out.println((a.concat("test ")).trim()); //trim()ȥ���ַ���ǰ��Ŀո�
		System.out.println(a.startsWith("eee")); //�ж��ַ������Ƿ���eee��ͷ
		System.out.println(a.endsWith("long")); //�ж��ַ����Ƿ���long��β
		System.out.println(a.indexOf('n')); //����l�ǵڼ���,�������ҵ�һ�γ���l��λ��
		System.out.println(a.lastIndexOf('n')); //�������󣬵�һ�γ���n��λ��
		System.out.println(a.charAt(3)); //�����ַ����������ַ�
		System.out.println(a.equalsIgnoreCase(a1)); //���Դ�Сд�Ƚ�
		System.out.println(a.compareTo(a1)); //����Ƚϣ������ַ�ASCII��ֵ
	}
	public static void main(String[] args) {
		test1();
		test2();
	}
}
