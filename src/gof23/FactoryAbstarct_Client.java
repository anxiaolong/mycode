package gof23;
/**
 * 测试抽象工厂模式
 * 抽象工厂是将产品类进一步进行分解，抽象为多个类
 * 代码复杂度增加，但更易于扩展
 * @author Administrator
 *
 */
public class FactoryAbstarct_Client {
	public static void main(String[] args) {
		FactoryAbstract_CarFactory factory = new FactoryAbstract_LuxuryCarFactory();
		FactoryAbstract_Engine engine = factory.createEngine();
		FactoryAbstract_Seat seat = factory.createSeat();
		FactoryAbstract_Tyre tyre = factory.createTyre();
		engine.start();
		seat.seat();
		tyre.run();
	}
}
