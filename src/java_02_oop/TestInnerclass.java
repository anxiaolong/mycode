package java_02_oop;
/**
 * 1.�ڲ����ⲿ���Ա�����ͷ����ķ���
 * 2.��̬�ڲ����ʹ�ã�����Ҫ��Ӧ���ⲿ�����
 * 3.�����ж����ڲ���
 * @author Administrator
 *
 */

public class TestInnerclass {
	private int age = 27;
	public static void main(String[] args) {
		TestInnerclass.TestInnerclass1 t1 = new TestInnerclass().new TestInnerclass1();
		t1.getAge();
		//��̬�ڲ��࣬û�ж�Ӧ���ⲿ����󣬲���ʹ��TestInnerclass�Ĺ�������ֱ�ӵ����Լ��Ĺ��췽������
		//�;�̬�������ƣ�����ֱ��ʹ��
		TestInnerclass.TestInnerclass2 t2 = new TestInnerclass.TestInnerclass2();
		t2.test();
	}
	public class TestInnerclass1 {
		public int age = 20;
		public void getAge() {
			int age = 10;
			System.out.println(age); //���ʷ����ڱ���
			System.out.println(this.age); //�����ڲ����Ա����
			System.out.println(TestInnerclass.this.age); //�����ⲿ�ڳ�Ա����
			//�ڷ����ж���һ���ڲ��ڣ���������ڷ�����
			class TestInnerclass3 {
				public void test() {
					System.out.println("�����е��ڲ���ִ��");
				}
			}
			TestInnerclass3 sInnerclass3 = new TestInnerclass3();
			sInnerclass3.test();
		} 
	}
	static class TestInnerclass2 {
		//����һ����̬�ڲ���
		public void test() {
			System.out.println("��̬�ڲ��ڷ���ִ��");
		}
	}	
}

