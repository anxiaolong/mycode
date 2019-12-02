package gof23;

public interface Facade_Zjj {
	void orgCodeCertificate();
}

class Cdzjj implements Facade_Zjj{

	@Override
	public void orgCodeCertificate() {
		System.out.println("办理组织机构代码证");
	}
	
}