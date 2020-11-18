package java_13_gof23;

public interface Facade_Swj {
	void taxCertificate();
}

class Cdswj implements Facade_Swj{

	@Override
	public void taxCertificate() {
		System.out.println("办理税务登记证");
	}
	
}