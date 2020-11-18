package java_13_gof23;
/**
 * 测试工厂方法模式
 * 产品和工厂都抽象为接口，添加一个产品对应添加一个工厂
 * @author Administrator
 *
 */
public class FactoryMethod_Client {
	public static void main(String[] args) {
		FactoryMethod_Car audi = new FactoryMethod_AudiFactory().createCar();
		audi.run();
	}
}
