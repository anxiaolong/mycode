package java_13_gof23;
/**
 * car工厂接口，需要能够创建汽车的三个基本部件
 * @author Administrator
 *
 */
public interface FactoryAbstract_CarFactory {
	public FactoryAbstract_Engine createEngine();
	public FactoryAbstract_Seat createSeat();
	public FactoryAbstract_Tyre createTyre();
}
