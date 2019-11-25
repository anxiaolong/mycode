package gof23;
/**
 * 发动机Engine接口和实体类
 * @author Administrator
 *
 */
public interface FactoryAbstract_Engine {
	public void start();
}

class LuxuryEngine implements FactoryAbstract_Engine {

	@Override
	public void start() {
		System.out.println("高端发动机启动");
	}
	
}

class LowEngine implements FactoryAbstract_Engine {

	@Override
	public void start() {
		System.out.println("低端发动机启动");
	}
	
}
