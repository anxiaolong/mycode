package cy_class;
/**
 * ����������GregorianCalendar
 */
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.atomic.AtomicBoolean;

public class TestGregorianCalendar {
	//��ȡGregorianCalendar������ز���
	public static void test1() {
		GregorianCalendar aCalendar = new GregorianCalendar(2019,10,2,11,12,33);
		System.out.println(aCalendar.toString());
		System.out.println(aCalendar.get(aCalendar.YEAR));
		System.out.println(aCalendar.get(aCalendar.MONTH));
		System.out.println(aCalendar.get(aCalendar.DAY_OF_MONTH)); //���µڼ���
		System.out.println(aCalendar.get(aCalendar.DATE));  //���µڼ����DAY_OF_MONTH��ͬ
		System.out.println(aCalendar.get(aCalendar.DAY_OF_WEEK));
	}
	//��ӡGregorianCalendar����
	public static void test2(GregorianCalendar a) {
		System.out.println(a.get(a.YEAR)+" "+a.get(a.MONTH)+" "+a.get(a.DAY_OF_MONTH));
	}
	//����GregorianCalendar����
	public static void test3() {
		GregorianCalendar aCalendar = new GregorianCalendar(2019, 10, 1);
		aCalendar.set(aCalendar.YEAR,2020);
		aCalendar.set(aCalendar.MONTH,11);
		System.out.println(aCalendar.get(aCalendar.YEAR));
		System.out.println(aCalendar.get(aCalendar.MONTH));
		test2(aCalendar);
	}
	//���ڼ���
	public static void test4() {
		GregorianCalendar aCalendar = new GregorianCalendar(2019,12,1);
		aCalendar.add(aCalendar.YEAR, -3);
//		aCalendar.add(aCalendar.MONTH, 3); //�·��Ǵ�0-11��0����12��
		test2(aCalendar);
	}
	//���ڶ�������������ת��,ͨ������ʱ�����ת��
	public static void test5() {
		//���ڶ���ת��������
		Date aDate = new Date();
		aDate.setTime(System.currentTimeMillis());
		System.out.println(aDate);
		GregorianCalendar aCalendar = new GregorianCalendar();
		aCalendar.setTime(aDate);
		System.out.println(aCalendar);
		//��������ת���ڶ���
		Date a1Date = new Date();
		GregorianCalendar aCalendar2 = new GregorianCalendar(2019,11,1,12,34,45);
		a1Date.setTime(aCalendar2.getTimeInMillis());
		System.out.println(a1Date);
	}
	public static void main(String[] args) {
		test1();
		test3();
		test4();
		test5();
	}
}
