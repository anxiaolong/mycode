package java_13_gof23;
/**
 * car�����ӿڣ���Ҫ�ܹ�����������������������
 * @author Administrator
 *
 */
public interface FactoryAbstract_CarFactory {
	public FactoryAbstract_Engine createEngine();
	public FactoryAbstract_Seat createSeat();
	public FactoryAbstract_Tyre createTyre();
}
