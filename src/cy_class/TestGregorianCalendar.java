package cy_class;
/**
 * 测试日历类GregorianCalendar
 */
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.atomic.AtomicBoolean;

public class TestGregorianCalendar {
	//获取GregorianCalendar对象相关参数
	public static void test1() {
		GregorianCalendar aCalendar = new GregorianCalendar(2019,10,2,11,12,33);
		System.out.println(aCalendar.toString());
		System.out.println(aCalendar.get(aCalendar.YEAR));
		System.out.println(aCalendar.get(aCalendar.MONTH));
		System.out.println(aCalendar.get(aCalendar.DAY_OF_MONTH)); //当月第几天
		System.out.println(aCalendar.get(aCalendar.DATE));  //当月第几天和DAY_OF_MONTH相同
		System.out.println(aCalendar.get(aCalendar.DAY_OF_WEEK));
	}
	//打印GregorianCalendar对象
	public static void test2(GregorianCalendar a) {
		System.out.println(a.get(a.YEAR)+" "+a.get(a.MONTH)+" "+a.get(a.DAY_OF_MONTH));
	}
	//设置GregorianCalendar参数
	public static void test3() {
		GregorianCalendar aCalendar = new GregorianCalendar(2019, 10, 1);
		aCalendar.set(aCalendar.YEAR,2020);
		aCalendar.set(aCalendar.MONTH,11);
		System.out.println(aCalendar.get(aCalendar.YEAR));
		System.out.println(aCalendar.get(aCalendar.MONTH));
		test2(aCalendar);
	}
	//日期计算
	public static void test4() {
		GregorianCalendar aCalendar = new GregorianCalendar(2019,12,1);
		aCalendar.add(aCalendar.YEAR, -3);
//		aCalendar.add(aCalendar.MONTH, 3); //月份是从0-11，0代表12月
		test2(aCalendar);
	}
	//日期对象和日历对象的转换,通过毫米时间进行转换
	public static void test5() {
		//日期对象转日历对象
		Date aDate = new Date();
		aDate.setTime(System.currentTimeMillis());
		System.out.println(aDate);
		GregorianCalendar aCalendar = new GregorianCalendar();
		aCalendar.setTime(aDate);
		System.out.println(aCalendar);
		//日历对象转日期对象
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
