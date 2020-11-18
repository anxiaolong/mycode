package java_01_grammar;

public class TestBreakAndContinue {
	public static void main(String[] args) {
		a:for (int i = 1; i < 11; i++) {
			for (int j = 1; j < i; j++) {
				if (i==5) {
					//break; //break直接跳出循环
					//a是标签，break和continue到这个标签所在代码行
					break a; //当i为偶数时，不继续往下执行，回到循环迭代因子继续执行
				}
				System.out.println(i+" "+j);
			}
		}
	}
}
