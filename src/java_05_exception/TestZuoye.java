package java_05_exception;
/**
 * 不能组成三角形抛出异常
 * @author Administrator
 *
 */
public class TestZuoye {
	int a,b,c;
	public void test() {
		if (a+b>c&&a+c>b&&b+c>a&&a!=0&&b!=0&&c!=0) {
			System.out.println(a+" "+b+" "+c);
		} else {
			throw new TestZuoye1("不能组成三角形");
		}
	}
	public static void main(String[] args) {
		TestZuoye t1TestZuoye = new TestZuoye();
		try {
			t1TestZuoye.a = 3;
			t1TestZuoye.b = 2;
			t1TestZuoye.c = 3;
			t1TestZuoye.test();
		} catch (TestZuoye1 e) {
			e.printStackTrace();
		}
	}
}

class TestZuoye1 extends RuntimeException {
	public TestZuoye1() {
		// TODO Auto-generated constructor stub
	}
	public TestZuoye1(String s) {
		super(s);
	}
}