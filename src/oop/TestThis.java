package oop;
/**
 * this�����Ѿ������õĶ���
 * 1.���Ʋ����ͳ�Ա�����޷����֣�ʹ��this����Ա������ֵ
 * 2.���췽�����ع����У����ڼ򻯴��룬������д�ڵ�һ��
 * 3.
 * @author Administrator
 *
 */

class A{
	
	int a,b,c;
	String s;
	double d;
	
	public void test1(int a) {
		//�����Ʋ����ͳ�Ա������ͻʱ���õ�thisָ����Ա����
		this.a = a;
	}
	
	public  A(int a,double d) {
		//���췽������
		this.a = a;
		this.b = b;
	}
	
	public  A(int a,String s,double d) {
		this(a, d); //�����˴������Ĺ��췽�������Լ򻯴��룬����д�ڵ�һ��
		this.s =s; 
	}
	public void test() {
		System.out.println("test����");
	}
	
	public static void test2(int a) {
//		this.a = a; //statci �����в���ʹ��this
	}
	
}

public class TestThis {
	public static void main(String[] args) {
		A a1 = new A(1, "anxiaolong", 3.12);
		a1.test();
	}
}
