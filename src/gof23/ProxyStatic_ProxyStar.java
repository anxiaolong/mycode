package gof23;
/**
 * ����star����
 * @author Administrator
 *
 */
public class ProxyStatic_ProxyStar implements ProxyStatic_star {
	private ProxyStatic_RealStar realstar;
	
	public ProxyStatic_ProxyStar(ProxyStatic_RealStar realstar) {
		this.realstar = realstar;
	}
	
	@Override
	public void signContract() {
		System.out.println("proxyStar.signContract");
	}

	@Override
	public void sing() {
		realstar.sing();
	}

	@Override
	public void collectMoney() {
		System.out.println("proxystar.collectMoney");
	}
	
}
