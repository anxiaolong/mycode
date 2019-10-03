package cy_class;
/**
 * ö�١�StringBuilder����װ�ࡢSimpleDateFormat
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.Scanner;

//ö�ٺ����
enum Light{
	red,yellow,green;
}

public class TestZuoye {
	//ʹ��enum��
	public static void test1() {
		int a = (int)(Math.random()*3);
		switch (Light.values()[a]) {
		case red:
			System.out.println("���ͣ��");
			break;
		case yellow:
			System.out.println("�Ƶ�����");
			break;
		case green:
			System.out.println("�̵�ͨ��");
			break;
		default:
			break;
		}
	}
	//�ж��ַ����Ƿ��������
	public static boolean isContainNumber(String s) {
		String[] n = {"0","1","2","3","4","5","6","7","8","9"};
		for (int i = 0; i < n.length; i++) {
			if (s.contains(n[i])) {
//				System.out.println("����");
				return true;
			}
		}
//		System.out.println("������");
		return false;
	}
	//�û�������Ϊ�գ����ȴ���6������������
	public static void test2() {
		while (true) {
			System.out.println("�û�������Ϊ�գ����ȴ���6�����������֣�");
			Scanner scanner = new Scanner(System.in);
			String s1 = scanner.nextLine();
			StringBuilder s = new StringBuilder(s1.replace(" ", ""));//ȥ������Ŀո�string�ǲ��ɱ��
//			System.out.println(s.toString());
			String s2String = new String(s); //�½�ȥ�ո������ַ���
			if (s2String.isEmpty()==false&&s2String.length()>6&&isContainNumber(s2String)==false) {
				break;
			}
		}
	}
	public static void main(String[] args) throws ParseException {
		System.out.println("�������䣺");
		Scanner ageScanner = new Scanner(System.in);
		String ageString = ageScanner.next();
		System.out.println("���������");
		Scanner pScanner = new Scanner(System.in);
		String pString = ageScanner.next();
		System.out.println("��ѧ����(yyyy-MM-dd)��");
		Scanner dateScanner = new Scanner(System.in);
		String dateString = ageScanner.next();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Double pDouble = new Double(pString);
		Integer ageInteger = new Integer(ageString);
		//��Ϊscnner���ܵĶ����ַ�����������Ӧ�İ�װ�����Ȼ�������Ӧ����������
		System.out.println(ageInteger.intValue());
		System.out.println(pDouble.doubleValue());
		System.out.println(dateFormat.parse(dateString)); //���ڸ�ʽ������dateFormat�����԰ѷ��ϸ�ʽ���ַ���ת��Ϊ����
	}
}


