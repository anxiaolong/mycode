package java_13_gof23;
/**
 * ��λ�ӿں�ʵ����
 * @author Administrator
 *
 */
public interface FactoryAbstract_Seat {
	public void seat();
}

class LuxurySeat implements FactoryAbstract_Seat {

	@Override
	public void seat() {
		System.out.println("�߶����Ρ�����");
	}
	
}

class LowSeat implements FactoryAbstract_Seat {

	@Override
	public void seat() {
		System.out.println("�Ͷ����Ρ�����");
	}
	
}