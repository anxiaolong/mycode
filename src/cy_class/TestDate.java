package cy_class;
/**
 * 测试java.util.Date类
 */
import java.util.Date;

public class TestDate {
	//获取系统当前时间（毫秒）
	public static void test1() {
		System.out.println(System.currentTimeMillis());
	}
	public static void main(String[] args) {
		Date d1 = new Date();
		System.out.println(d1.toString());
//		System.out.println(d1.getTime());
		long i = d1.getTime();
		Date d2 = new Date(i-1000);
		Date d3 = new Date(i+1000);
		System.out.println(d1.after(d2));
		System.out.println(d1.before(d3));
		System.out.println(d1.equals(d3));
		System.out.println(new Date(1000L * 60 * 60 * 24 * 365 * 39L).toString());
	}
}
