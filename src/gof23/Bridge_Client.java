package gof23;
/**
 * 测试桥接模式
 * @author Administrator
 *
 */
public class Bridge_Client {
	public static void main(String[] args) {
		//销售联想笔记本电脑
		Bridge_Computer lenovoLaptop = new Laptop(new Lenovo());
		lenovoLaptop.sale();
		//销售戴尔台式机
		Bridge_Computer dellDesktop = new Desktop(new Dell());
		dellDesktop.sale();
	}
}
