package oop;

import java.util.jar.Attributes.Name;

class  Test {
	int a; //����һ����ͨ�ĳ�Ա�������������ʹ��
	static String name = "anxiaolong"; //��̬������������
	
	//static���ε��Ǿ�̬��������������
	public static void test() {
		System.out.println("static����");
	}
	
	public void test(int a) {
		System.out.println("��ͨ����");
	}
}

public class TestStatci {
	public static void main(String[] args) {
		System.out.println(Test.name); //��̬��������ֱ�ӵ���
		Test Test1 = new Test();
		Test1.a = 222;
		System.out.println(Test1.a); //��ͨ��������Զ���ʹ��
	}
}
