package oop;
/**
 * ���췽���ǴӸ�������ִ��
 * @author Administrator
 *
 */

public class TestSuperGz {
	public static void main(String[] args) {
		new TestTestSuperGz3();
	}
}

class TestTestSuperGz1 {
	
	public TestTestSuperGz1() {
		System.out.println("ִ����1�����췽��");
	}
}

class TestTestSuperGz2 extends TestTestSuperGz1 {
	
	public TestTestSuperGz2() {
		System.out.println("ִ����2�����췽��");
	}
}

class TestTestSuperGz3 extends TestTestSuperGz2 {
	
	public TestTestSuperGz3() {
		System.out.println("ִ����3�����췽��");
	}
}