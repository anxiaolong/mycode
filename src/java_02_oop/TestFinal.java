package java_02_oop;

public class TestFinal {
	public static void main(String[] args) {
		TestFinal2 testFinal2 = new TestFinal2();
//		testFinal2.a = 1; //���ɶ�final���εĳ�Ա������ֵ
	}
}

final class TestFinal1 {
	
}

//final ���ε��಻�ܱ��̳�
//class TestFinal2 extends TestFinal1 {
//	
//}

class TestFinal2 {
	final int a = 10;
	
	final void test() {
		System.out.println("eeee");
	}
	//final���εķ������Ա�����
	final void test(int a) {
		System.out.println(a);
	}
}

class TestFinal3 extends TestFinal2 {
	//final ���εķ������ܱ���д
//	final void test() {
//		System.out.println("eeee");
//	}
}
