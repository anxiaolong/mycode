package oop;
/**
 * ����super��ʹ�ã����ø��෽���ͳ�Ա����
 * @author Administrator
 *
 */
public class TestSuper {
	public static void main(String[] args) {
		TestSuper2 t1 = new TestSuper2(2,3);
		t1.testSuper();
	}
}

class TestSuper1 {
	int a;
	int b;
	static String name = "anxiaolong";
	
	public void test() {
		System.out.println("���Ǹ��෽��");
	}
	public TestSuper1(int a) {
		this.a = a;
	}
	
	//��д���Ϊ�յĹ��췽����������д���췽���ᱨ��
	public TestSuper1() {
		// TODO Auto-generated constructor stub
	}
	
}

class  TestSuper2 extends TestSuper1 {
	String name;
	
	public void testSuper() {
		super.test(); //���ø���ķ���
		System.out.println("���ø����Ա����:"+super.name); //���ø����Ա����
	}
	public TestSuper2(int a,int b) {
		this.a = a;
		this.b = b;
	}
}