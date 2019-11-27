package gof23;
/**
 * realstar 实现了start这个接口
 * @author Administrator
 *
 */
public class ProxyStatic_RealStar implements ProxyStatic_star {

	@Override
	public void signContract() {
		System.out.println("realstar.signContract");
	}

	@Override
	public void sing() {
		System.out.println("realstar.sing");
	}

	@Override
	public void collectMoney() {
		System.out.println("realstar.collectMoney");
	}
	
}
