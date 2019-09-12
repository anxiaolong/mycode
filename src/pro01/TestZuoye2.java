package pro01;

import java.util.Scanner;

public class TestZuoye2 {
	public static void main(String[] args) {
		//
//		Scanner scnner = new Scanner(System.in);
//		int a = scnner.nextInt();
//		Test(100);
//		System.out.println(Sum(5));
		System.out.println(Fb(40));

	}
	
	//斐波那契数列
	public static int Fb(int n) {
		//第1，2两个数特殊处理下
		if (n==1 || n==2 ) {
			return 1;
		} else {
			return Fb(n-1)+Fb(n-2);
		}
	}
	//使用递归求集合的和
	public static int Sum(int a) {
		if (a == 1) {
			return 1;
		} else {
			return a*(a+1)/2 + Sum(a-1);
		}
	}
	
	//把10进制转换为2进制，二进制数从右到左
	public static void Test(int a) {
		while (a>0) {
			if (a==1) {
				System.out.print(a);
				break;
			} else {
				
				System.out.print(a%2);
			}
			a = a/2;
//			System.out.println(a);
		}
	}
}
