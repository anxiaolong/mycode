package gof23;
/**
 * һ��������
 * @author Administrator
 *
 */
public class FactoryMethod_AudiFactory implements FactoryMethod_Factory {

	@Override
	public FactoryMethod_Car createCar() {
		// TODO Auto-generated method stub
		return new FactoryMethod_Audi();
	}
	
}
