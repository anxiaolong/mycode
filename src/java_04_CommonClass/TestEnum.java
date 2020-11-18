package java_04_CommonClass;
/**
 * 测试枚举的使用
 * @author Administrator
 *
 */
public class TestEnum {
	public static void main(String[] args) {
		//foreach循环出枚举里面的所有内容
		for (Season s : Season.values()) { 
			System.out.println(s);
		}
		for (Week w : Week.values()) {
			System.out.println(w);
		}
		//
		int a = (int)(Math.random()*4);
		switch (Season.values()[a]) {
		case 春:
			System.out.println("春");
			break;
		case 夏:
			System.out.println("夏");
			break;
		case 秋:
			System.out.println("秋");
			break;
		case 冬:
			System.out.println("冬");
			break;
		default:
			System.out.println("没有在枚举类之中");
			break;
		}
	}
}


enum Season{
	春,夏,秋,冬;
}

enum Week{
	星期一,星期二,星期三,星期四,星期五,星期六,星期日;
}