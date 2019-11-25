package gof23;
/**
 * 一个产品类
 * @author Administrator
 *
 */
public class FactoryMethod_Audi implements FactoryMethod_Car {

	@Override
	public void run() {
		System.out.println("奥迪Running");
	}

}
