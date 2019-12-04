package gof23;
/**
 * 新客户 够买的多
 * @author Administrator
 *
 */
public class Strategy_NewCustomerMany implements Strategy_Strategy {

	@Override
	public double getPrice(double standardPrice) {
		System.out.println("打九折");
		return standardPrice*0.9;
	}
	
}
