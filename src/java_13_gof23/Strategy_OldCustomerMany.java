package java_13_gof23;
/**
 * �Ͽͻ� ����Ķ�
 * @author Administrator
 *
 */
public class Strategy_OldCustomerMany implements Strategy_Strategy {

	@Override
	public double getPrice(double standardPrice) {
		System.out.println("�����");
		return standardPrice*0.8;
	}
	
}
