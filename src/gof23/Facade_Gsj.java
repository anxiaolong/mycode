package gof23;

public interface Facade_Gsj {
	void checkName();
}

class Cdgsj implements Facade_Gsj{

	@Override
	public void checkName() {
		System.out.println("��������Ƿ�������");
	}
	
}