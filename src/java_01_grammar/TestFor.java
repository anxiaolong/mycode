package java_01_grammar;

public class TestFor {
	public static void main(String[] args) {
		//计算1加到100,初始化变量作用域只在于for循环内部
		int sum = 0;
		for (int i = 1; i <= 100; i++) {
			sum += i;
		}
		System.out.println(sum);
//		//死循环
//		int i = 1;
//		for (;;) {
//			System.out.println(i);
//			i ++ ;
		//while 死循环
//		int i = 1;
//		while (true) {
//			System.out.println(i);
//			i ++ ;
//		}
		
	}
}
