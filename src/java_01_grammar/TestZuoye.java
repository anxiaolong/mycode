/**
 * 1.Java是一种强类型语言，说明Java的数据类型分类。
 * 整型：byte short int long 
 * 浮点：float double
 * 字符：char
 * 布尔：Boolean
 * 引用类型：class interface 数组
 
2.i++和++i的异同之处
i++是先使用值，++i是先自增再使用

3.运算符||和|的异同之处
短路可以提升代码性能 

4.Java中基本数据类型转换的规则

 */

package java_01_grammar;

import java.util.Scanner;

public class TestZuoye {
	public static void main(String[] args) {
//		float r = 2.5F;
//		float pi = 3.14F;  //使用float类型
//		double r = 2.5; //使用double
//		double pi = 3.14;
//		System.out.println("周长="+2*pi*r);
//		System.out.println("面积="+pi*Math.pow(r, 2));
		
//		double c = 10000;
//		System.out.println("一年活期后本金和利息="+Math.round(c*(1+0.0035)));
//		System.out.println("两年活期后本金和利息="+Math.round(c*(Math.pow((1+0.0035), 2))));
//		System.out.println("一年定期后本金和利息="+Math.round(c*(1+0.015)));
//		System.out.println("两年定期后本金和利息="+Math.round(c*(Math.pow((1+0.021), 2))));
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("输入4位数字：");
		int a = scanner.nextInt();
		int a1 = a/1000;
		int a2 = (a-a1*1000)/100;
		int a3 = (a-a1*1000-a2*100)/10;
		int a4 = a-a1*1000-a2*100-a3*10;
//		System.out.printf("%d,%d,%d,%d", a1,a2,a3,a4);
		
		int t1=0,t2=0;
		t1 = a1;
		a1 = a4;
		a4 = t1;
		
		t2 = a2;
		a2 = a3;
		a3 = t2;
		System.out.printf("%d,%d,%d,%d \n",a1,a2,a3,a4 );
		
		System.out.println(a1*1000+a2*100+a3*10+a4);
		
	}
}
