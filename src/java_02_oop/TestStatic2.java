package java_02_oop;

class TestStatic3 {
	int a;
	int b;
	
	//statci ���ε������еĴ��룬����ļ������ʱ��ͻᱻִ��
	static {
		System.out.println("statci���ھ�̬��ʼ����"); 
	}
}


public class TestStatic2 {
	public static void main(String[] args) {
		TestStatic3 test1 = new TestStatic3();
	}
	
}
