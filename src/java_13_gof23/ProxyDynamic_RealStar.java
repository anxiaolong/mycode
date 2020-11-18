package java_13_gof23;

public class ProxyDynamic_RealStar implements ProxyDynamic_Star {

	@Override
	public void confer() {
		System.out.println("RealStar.confer");
	}

	@Override
	public void signContract() {
		System.out.println("RealStar.signContract");
	}

	@Override
	public void bookTicket() {
		System.out.println("RealStar.bookTicket");
	}

	@Override
	public void sing() {
		System.out.println("RealStar(ÖÜ½ÜÂ×±¾ÈË).sing");
	}

	@Override
	public void collectMoney() {
		System.out.println("RealStar.collectMoney");
	}

	
}
