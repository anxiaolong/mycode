package gof23;

public abstract class TemplateMethod_Bank {
	public void takeNumber() {
		System.out.println("取号排队");
	}
	
	//具体处理业务的方法
	public abstract void transact();
	
	public void evaluate() {
		System.out.println("反馈评分");
	}
	
	//模板方法
	public final void process() {
		this.takeNumber();
		this.transact();
		this.evaluate();
	}
}
