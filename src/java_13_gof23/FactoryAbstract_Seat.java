package java_13_gof23;
/**
 * 座位接口和实体类
 * @author Administrator
 *
 */
public interface FactoryAbstract_Seat {
	public void seat();
}

class LuxurySeat implements FactoryAbstract_Seat {

	@Override
	public void seat() {
		System.out.println("高端座椅。。。");
	}
	
}

class LowSeat implements FactoryAbstract_Seat {

	@Override
	public void seat() {
		System.out.println("低端座椅。。。");
	}
	
}