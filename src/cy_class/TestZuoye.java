package cy_class;
/**
 * 枚举、StringBuilder、包装类、SimpleDateFormat
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.Scanner;

//枚举红黄绿
enum Light{
	red,yellow,green;
}

public class TestZuoye {
	//使用enum类
	public static void test1() {
		int a = (int)(Math.random()*3);
		switch (Light.values()[a]) {
		case red:
			System.out.println("红灯停车");
			break;
		case yellow:
			System.out.println("黄灯慢行");
			break;
		case green:
			System.out.println("绿灯通行");
			break;
		default:
			break;
		}
	}
	//判断字符中是否包含数字
	public static boolean isContainNumber(String s) {
		String[] n = {"0","1","2","3","4","5","6","7","8","9"};
		for (int i = 0; i < n.length; i++) {
			if (s.contains(n[i])) {
//				System.out.println("包含");
				return true;
			}
		}
//		System.out.println("不包含");
		return false;
	}
	//用户名不能为空，长度大于6，不能有数字
	public static void test2() {
		while (true) {
			System.out.println("用户名不能为空，长度大于6，不能有数字：");
			Scanner scanner = new Scanner(System.in);
			String s1 = scanner.nextLine();
			StringBuilder s = new StringBuilder(s1.replace(" ", ""));//去除输入的空格，string是不可变的
//			System.out.println(s.toString());
			String s2String = new String(s); //新建去空格后的新字符产
			if (s2String.isEmpty()==false&&s2String.length()>6&&isContainNumber(s2String)==false) {
				break;
			}
		}
	}
	public static void main(String[] args) throws ParseException {
		System.out.println("输入年龄：");
		Scanner ageScanner = new Scanner(System.in);
		String ageString = ageScanner.next();
		System.out.println("输入分数：");
		Scanner pScanner = new Scanner(System.in);
		String pString = ageScanner.next();
		System.out.println("入学日期(yyyy-MM-dd)：");
		Scanner dateScanner = new Scanner(System.in);
		String dateString = ageScanner.next();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Double pDouble = new Double(pString);
		Integer ageInteger = new Integer(ageString);
		//因为scnner接受的都是字符串，建立对应的包装类对象，然后输出对应的数据类型
		System.out.println(ageInteger.intValue());
		System.out.println(pDouble.doubleValue());
		System.out.println(dateFormat.parse(dateString)); //日期格式化对象dateFormat，可以把符合格式的字符串转化为日期
	}
}


