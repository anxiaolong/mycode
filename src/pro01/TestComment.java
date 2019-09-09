package pro01;
/**
 * 这个程序主要是测试Java中的注释
 * 包含：单行注释、多行注释、文档注释
 *（当前这个注释为文档注释）
 * @author 安小龙
 *
 */

public class TestComment {
	/*
	 * 这里是多行注释
	 * 可以写很多行
	 */
	public static void main(String[]/*多行注释一个小技巧，
	可以在括号内进行注释，不影响程序执行*/ args) {
		System.out.println("测试Java中的注释！");//这里是单行注释
	}
}
