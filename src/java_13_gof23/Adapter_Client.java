package java_13_gof23;
/**
 * 测试适配器模式
 * @author Administrator
 *
 */
public class Adapter_Client {
	public static void main(String[] args) {
		//测试通过继承实现的适配器
		Adapter_Adapter1 a1 = new Adapter_Adapter1();
		a1.acceptInput();
		
		//测试通过组合实现的适配器
		Adapter_Adapter2 a2 = new Adapter_Adapter2(new Adapter_Keyboard());
		a2.handleInput();
	}
}
