package java_13_gof23;
/**
 * 老客户 够买的多
 * @author Administrator
 *
 */
public class Strategy_OldCustomerMany implements Strategy_Strategy {

	@Override
	public double getPrice(double standardPrice) {
		System.out.println("打八折");
		return standardPrice*0.8;
	}
	
}
