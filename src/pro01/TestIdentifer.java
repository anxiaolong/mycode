package pro01;
/**
 * 这个程序主要是测试标识符规则
 * @author 安小龙
 *
 */

public class TestIdentifer {
	public static void main(String[] args) {
		//int #d = 10; #号不能作为变量开头
		int $a =10 ;//$符可以作为变量开头
		//int 123aba = 10; 数字不能作为变量开头
		int _a = 11;
		int a123 =33;
		//int class = 11; 关键字不能作为变量名
		int 测试 = 11;//汉字可以作为变量名 但是一般不这么用
		System.out.println("测试标识符规则！");
	}

}
