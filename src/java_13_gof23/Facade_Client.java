package java_13_gof23;
/**
 * 测试外观模式，本质上就是封装的思想
 * @author Administrator
 *
 */
public class Facade_Client {
	public static void main(String[] args) {
		Facade_Register register = new Facade_Register();
		register.register();
	}
}
