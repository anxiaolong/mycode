package java_13_gof23;
/**
 * 高端车工厂实体类
 * @author Administrator
 *
 */
public class FactoryAbstract_LuxuryCarFactory implements FactoryAbstract_CarFactory {

	@Override
	public FactoryAbstract_Engine createEngine() {
		return new LuxuryEngine();
	}

	@Override
	public FactoryAbstract_Seat createSeat() {
		return new LuxurySeat();
	}

	@Override
	public FactoryAbstract_Tyre createTyre() {
		return new LuxuryTyre();
	}

}
