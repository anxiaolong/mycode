package gof23;

public abstract class TemplateMethod_Bank {
	public void takeNumber() {
		System.out.println("ȡ���Ŷ�");
	}
	
	//���崦��ҵ��ķ���
	public abstract void transact();
	
	public void evaluate() {
		System.out.println("��������");
	}
	
	//ģ�巽��
	public final void process() {
		this.takeNumber();
		this.transact();
		this.evaluate();
	}
}
