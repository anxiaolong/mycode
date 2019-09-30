package cy_class;
/**
 * ����SimpleDateFormat���ʹ�� ���ڸ�ʽ��
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestSimpleDateFormat {
	//��ʹ��SimpleDateFormat��
	public static void test1() throws ParseException {
		//���й̶�ʱ���ʽ��SimpleDateFormat����
		SimpleDateFormat a1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		SimpleDateFormat a2 = new SimpleDateFormat("yyyy-MM-dd");
		//ʱ��ת��Ϊ�ַ��������԰����Լ��������ʽ������
		String a1String = a1.format(new Date());
		System.out.println(a1String);
		System.out.println(new SimpleDateFormat("yyyy��MM��dd�� hh��mm��ss��").format(System.currentTimeMillis()));
		//ָ����ʽ�ַ���ת��Ϊʱ��
		String s1 = "2019-12-27";
		String s2 = "2019-11-11 11:22:33";
		Date d1 = a2.parse(s1); //ʹ��parse����ת��Ϊʱ��
		System.out.println(d1);
		Date d2 = a1.parse(s2);
		System.out.println(d2);
	}
	//��ǰʱ���ǽ���ĵڼ���
	public static void test2() {
		//��ǰʱ���ǽ���ĵڼ���
		SimpleDateFormat a = new SimpleDateFormat("D"); //D��ʾһ��ĵڼ���
//		System.out.println(a.format(System.currentTimeMillis())); //ͨ������currentTimeMillis��ȡʱ��
		System.out.println(a.format((new Date()).getTime())); //ͨ��Date�������getTime��ȡ��ǰʱ��
	}
	public static void main(String[] args) throws ParseException {
		test1();
		test2();
	}
}
