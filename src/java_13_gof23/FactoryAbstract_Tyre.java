package java_13_gof23;
/**
 * ��̥�ӿں�ʵ����
 * @author Administrator
 *
 */
public interface FactoryAbstract_Tyre {
	public void run();
}

class LuxuryTyre implements FactoryAbstract_Tyre {

	@Override
	public void run() {
		System.out.println("�߶���̥�ܵÿ죬��ĥ��");
	}
	
}

class LowTyre implements FactoryAbstract_Tyre {

	@Override
	public void run() {
		System.out.println("�Ͷ���̳����ĥ��");
	}
	
}
