package gof23;

public interface Facade_Bank {
	void openAccount();
}

class Cdbank implements Facade_Bank{

	@Override
	public void openAccount() {
		System.out.println("�����п���");
	}
	
}
