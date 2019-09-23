package exception;
/**
 * 自定义异常类测试
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

//自定义异常类
class MyException extends RuntimeException {
	public MyException() {}
	//自定义异常类对象的构造方法
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
			throw new MyException("年龄不能为负数");
		}
		this.age = age;
	}
	
}

