package exception;

public class TestException2 {
	public static void main(String[] args) {
		Input t1Input = new Input();
		try {
			t1Input.setF(101);
		} catch (TestException21 e) {
			e.printStackTrace();
		}
	}
}

class TestException21 extends RuntimeException {
	public TestException21() {}
	public TestException21(String s) {
		super(s);
	}
}

class Input {
	private int f;

	public int getF() {
		return f;
	}

	public void setF(int f) {
		if (f<0||f>100) {
			throw new TestException21("分数再0~100之间");
		}
		this.f = f;
	}
	
}