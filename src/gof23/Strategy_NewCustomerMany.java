package gof23;
/**
 * �¿ͻ� ����Ķ�
 * @author Administrator
 *
 */
public class Strategy_NewCustomerMany implements Strategy_Strategy {

	@Override
	public double getPrice(double standardPrice) {
		System.out.println("�����");
		return standardPrice*0.9;
	}
	
}
