package exception;
/**
 * �Զ����쳣�����
 * @author Administrator
 *
 */
public class TestException {
	public static void main(String[] args) {
		TestException1 t1Exception1 = new TestException1();
		try {
			t1Exception1.setAge(-1);
		} catch (MyException e) {
			e.printStackTrace();
		}
	}
}

//�Զ����쳣��
class MyException extends RuntimeException {
	public MyException() {}
	//�Զ����쳣�����Ĺ��췽��
	public MyException(String s) {
		super(s); 
	}
}

class TestException1 {
	private int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if (age<0) {
			throw new MyException("���䲻��Ϊ����");
		}
		this.age = age;
	}
	
}

