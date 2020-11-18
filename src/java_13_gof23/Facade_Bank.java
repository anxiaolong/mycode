package java_13_gof23;

public interface Facade_Bank {
	void openAccount();
}

class Cdbank implements Facade_Bank{

	@Override
	public void openAccount() {
		System.out.println("在银行开户");
	}
	
}
