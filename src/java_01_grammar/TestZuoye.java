/**
 * 1.Java��һ��ǿ�������ԣ�˵��Java���������ͷ��ࡣ
 * ���ͣ�byte short int long 
 * ���㣺float double
 * �ַ���char
 * ������Boolean
 * �������ͣ�class interface ����
 
2.i++��++i����֮ͬ��
i++����ʹ��ֵ��++i����������ʹ��

3.�����||��|����֮ͬ��
��·���������������� 

4.Java�л�����������ת���Ĺ���

 */

package java_01_grammar;

import java.util.Scanner;

public class TestZuoye {
	public static void main(String[] args) {
//		float r = 2.5F;
//		float pi = 3.14F;  //ʹ��float����
//		double r = 2.5; //ʹ��double
//		double pi = 3.14;
//		System.out.println("�ܳ�="+2*pi*r);
//		System.out.println("���="+pi*Math.pow(r, 2));
		
//		double c = 10000;
//		System.out.println("һ����ں󱾽����Ϣ="+Math.round(c*(1+0.0035)));
//		System.out.println("������ں󱾽����Ϣ="+Math.round(c*(Math.pow((1+0.0035), 2))));
//		System.out.println("һ�궨�ں󱾽����Ϣ="+Math.round(c*(1+0.015)));
//		System.out.println("���궨�ں󱾽����Ϣ="+Math.round(c*(Math.pow((1+0.021), 2))));
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("����4λ���֣�");
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
