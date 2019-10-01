package cy_class;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * 可视化日历
 * @author Administrator
 *
 */
public class TestCalendar {
	public static void main(String[] args) {
		
		//从键盘获取yyyy-MM-dd格式的日期
		System.out.println("请输入日期，格式如：2019-01-01:\n");
		Scanner s = new Scanner(System.in);
		String s_date = s.next();
		
		//将输入的字符串转化为日历类对象
		String[] s1 = s_date.split("-"); //以-将字符串床划分为数组
		int year = Integer.parseInt(s1[0]); //直接将字符串转换为整型数
		int month = Integer.parseInt(s1[1]);
		int dayOfMonth = Integer.parseInt(s1[2]);
		GregorianCalendar g = new GregorianCalendar(year, month-1, dayOfMonth); //月是0-11
		
		g.set(Calendar.DAY_OF_MONTH, 1); //设置日期为当月1号
		int dow = g.get(Calendar.DAY_OF_WEEK); //1号对应的日期是一周的第几天
//		System.out.println(dow);  //1号对应的是一周的第三天
		System.out.println("日\t一\t二\t三\t四\t五\t六");
		for (int i = 0; i < dow - 1; i++) {
            System.out.print("\t");  //打印两个空格，1号被放在星期二位置
        }
		int maxDate = g.getActualMaximum(Calendar.DAY_OF_MONTH); //获取当月日期最大值
//        System.out.println("maxDate:"+maxDate);
        for (int i = 1; i <= maxDate; i++) {  //把1-31号的日期全部打印出来
            StringBuilder sBuilder = new StringBuilder();
            if (g.get(Calendar.DATE) == dayOfMonth) {
                sBuilder.append(g.get(Calendar.DATE) + "*\t"); //如何和输入日期相同加*
            } else {
                sBuilder.append(g.get(Calendar.DATE) + "\t");
            }
            System.out.print(sBuilder);
 
            if (g.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) { 
                System.out.print("\n"); //遇到星期六 换行
            }
            g.add(Calendar.DATE, 1);//循环一次，日期数加1
        }
	} 
}
