package exception;
/**
 * 直到输入正确之后跳出，否则抛异常
 */
import java.util.Scanner;

public class TestZuoye02 {
	public static void main(String[] args) {
		TestZuoye021 t1TestZuoye021 = new TestZuoye021();
		while (true) {
			try {
				System.out.println("输入分数：");
				Scanner qScanner = new Scanner(System.in);
				t1TestZuoye021.setA(qScanner.nextInt());
				break; //break放在try中，不抛异常直接退出循环
			} catch (TestZuoye022 e) {
				e.printStackTrace();
			}
		}
		
	}
}

class TestZuoye021 {
	private int a;

	public int getA() {
		return a;
	}

	public void setA(int a) {
		if (a<0) {
			throw new TestZuoye022("分数不能为负数");
		} 
		this.a = a;
	}
}

class TestZuoye022 extends RuntimeException {
	public TestZuoye022() {
		// TODO Auto-generated constructor stub
	}
	public TestZuoye022(String s) {
		super(s);
	}
}