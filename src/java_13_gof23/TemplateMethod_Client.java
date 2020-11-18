package java_13_gof23;
/**
 * 测试模板方法模式
 * 使用继承实现业务 使用匿名内部类实现业务
 * @author Administrator
 *
 */
public class TemplateMethod_Client {
	public static void main(String[] args) {
		//通过继承模仿方法抽象类，具体实现业务
		TemplateMethod_Bank t1 = new DrawMoney();
		t1.process();
		
		//通过匿名内部类实现具体业务
		TemplateMethod_Bank t2 = new TemplateMethod_Bank() {
			
			@Override
			public void transact() {
				System.out.println("办理存钱");
			}
		};
		t2.process();
		
		TemplateMethod_Bank t3 = new TemplateMethod_Bank() {
			
			@Override
			public void transact() {
				System.out.println("办理投资理财");
			}
		};
		t3.process();
	}
}


class DrawMoney extends TemplateMethod_Bank{

	@Override
	public void transact() {
		System.out.println("办理取钱业务");
	}
	
}