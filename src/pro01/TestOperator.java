package pro01;
/**
 * 二元运算符，需要两个变量参与运算
 * 一元运算++ --，只需要一个值就可以
 * += -+ *= /= %= 关系运算符的结果是布尔值
 * @author Administrator
 *
 */
public class TestOperator {
	public static void main(String[] args) {
//		System.out.print((10%-3)+"\n"); //值为1，余数的正负值和左边%左边的符号相关
//		int a = 3;
//		int b = a--; //a的值先赋值给b，再自增/自减
//		int c = --a; //c的值先自增/自减，再复制给c
//		System.out.print("a="+a+"\nb="+b+"\nc="+c);
		int m = 2;
		int n = 13;
//		System.out.println(m+=n);
//		System.out.println(m-=n);
//		System.out.println(m*=n);
//		System.out.println(m/=n);
//		System.out.println(m%=n);
		System.out.println(m>n);
		System.out.println(m<n);
		System.out.println(m>=n);
		System.out.println(m<=n);
		System.out.println(m==n); //=是赋值，==才是判断
		System.out.println(m!=n);
		
	}
}
