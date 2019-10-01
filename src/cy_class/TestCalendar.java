package cy_class;
/**
 * 可视化日历
 * @author Administrator
 *
 */
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;


public class TestCalendar {
	public static void test1() {
		
	}
	public static void main(String[] args) {
		//键盘输入
		System.out.println("输入格式如yyyy-MM-dd的日期：");
		Scanner inScanner = new Scanner(System.in);
		String aString = inScanner.next();
		
		String[] a = aString.split("-"); //将字符串拆分为数组
		System.out.println(Arrays.toString(a)); 
		int y = Integer.parseInt(a[0]);
		int m = Integer.parseInt(a[1]);
		int d = Integer.parseInt(a[2]);
		//new一个GregorianCalendar对象
		GregorianCalendar g = new GregorianCalendar(y,m-1,d); //月份一定要-1
		System.out.println("日\t一\t二\t三\t四\t五\t六");
		g.set(Calendar.DAY_OF_MONTH, 1); //g的日期设置为1号
//		System.out.println(g.get(Calendar.DAY_OF_WEEK)); //当前日期是一周中的第几天
		for (int i = 1; i < g.get(Calendar.DAY_OF_WEEK); i++) {
			System.out.print("\t"); //日历第一行空格，根据是一周的第几天计算
		}
		int max = g.getActualMaximum(Calendar.DAY_OF_MONTH); //获取当月最大天数
		for (int i = 1; i <= max; i++) {
			if ((g.get(Calendar.DAY_OF_MONTH)==d)) {
				System.out.print(g.get(Calendar.DAY_OF_MONTH)+"*\t"); //判断如果是当日加*
			} else {
				System.out.print(g.get(Calendar.DAY_OF_MONTH)+"\t");
			}	
			if (g.get(Calendar.DAY_OF_WEEK)==7) {
				System.out.println(); //判断是星期六，换行
			}
			g.add(Calendar.DAY_OF_MONTH, 1);
		}
		}
}













