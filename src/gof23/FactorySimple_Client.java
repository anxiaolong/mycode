package gof23;
/**
 * 测试简单工厂模式
 * 工厂模式的好处是避免直接和基础类做业务交互，符合开闭原则
 * 
 * @author Administrator
 *
 */
public class FactorySimple_Client {
	public static void main(String[] args) {
		//不适用工厂模式创建对象
		FactorySimple_Audi car1 = new FactorySimple_Audi();
		FactorySimple_Byd car2 = new FactorySimple_Byd();
		car1.run();
		car2.run();
		
		//使用工厂模式创建对象
		FactorySimple_Car audi = FactorySimple_CarFactory.creatAudi();
		FactorySimple_Car byd = FactorySimple_CarFactory.creatByd();
		audi.run();
		byd.run();
	}
}
