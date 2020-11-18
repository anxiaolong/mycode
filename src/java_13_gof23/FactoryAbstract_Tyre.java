package java_13_gof23;
/**
 * 轮胎接口和实体类
 * @author Administrator
 *
 */
public interface FactoryAbstract_Tyre {
	public void run();
}

class LuxuryTyre implements FactoryAbstract_Tyre {

	@Override
	public void run() {
		System.out.println("高端轮胎跑得快，不磨损");
	}
	
}

class LowTyre implements FactoryAbstract_Tyre {

	@Override
	public void run() {
		System.out.println("低端论坛容易磨损");
	}
	
}
