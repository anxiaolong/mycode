package gof23;
/**
 * ������Engine�ӿں�ʵ����
 * @author Administrator
 *
 */
public interface FactoryAbstract_Engine {
	public void start();
}

class LuxuryEngine implements FactoryAbstract_Engine {

	@Override
	public void start() {
		System.out.println("�߶˷���������");
	}
	
}

class LowEngine implements FactoryAbstract_Engine {

	@Override
	public void start() {
		System.out.println("�Ͷ˷���������");
	}
	
}
