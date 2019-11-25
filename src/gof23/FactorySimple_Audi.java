package gof23;
/**
 * 新建一个车类别，实现car
 * @author Administrator
 *
 */
public class FactorySimple_Audi implements FactorySimple_Car {

	@Override
	public void run() {
		System.out.println("奥迪Running");
	}

}
