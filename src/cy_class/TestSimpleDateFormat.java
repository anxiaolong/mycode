package cy_class;
/**
 * 测试SimpleDateFormat类的使用 日期格式化
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestSimpleDateFormat {
	//简单使用SimpleDateFormat类
	public static void test1() throws ParseException {
		//具有固定时间格式的SimpleDateFormat对象
		SimpleDateFormat a1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		SimpleDateFormat a2 = new SimpleDateFormat("yyyy-MM-dd");
		//时间转化为字符串，可以按照自己需求定义格式化内容
		String a1String = a1.format(new Date());
		System.out.println(a1String);
		System.out.println(new SimpleDateFormat("yyyy年MM月dd日 hh点mm分ss秒").format(System.currentTimeMillis()));
		//指定格式字符串转化为时间
		String s1 = "2019-12-27";
		String s2 = "2019-11-11 11:22:33";
		Date d1 = a2.parse(s1); //使用parse方法转换为时间
		System.out.println(d1);
		Date d2 = a1.parse(s2);
		System.out.println(d2);
	}
	//当前时间是今年的第几天
	public static void test2() {
		//当前时间是今年的第几天
		SimpleDateFormat a = new SimpleDateFormat("D"); //D表示一年的第几天
//		System.out.println(a.format(System.currentTimeMillis())); //通过调用currentTimeMillis获取时间
		System.out.println(a.format((new Date()).getTime())); //通过Date对象调用getTime获取当前时间
	}
	public static void main(String[] args) throws ParseException {
		test1();
		test2();
	}
}
