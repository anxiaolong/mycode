package java_13_gof23;
/**
 * ����ģ�巽��ģʽ
 * ʹ�ü̳�ʵ��ҵ�� ʹ�������ڲ���ʵ��ҵ��
 * @author Administrator
 *
 */
public class TemplateMethod_Client {
	public static void main(String[] args) {
		//ͨ���̳�ģ�·��������࣬����ʵ��ҵ��
		TemplateMethod_Bank t1 = new DrawMoney();
		t1.process();
		
		//ͨ�������ڲ���ʵ�־���ҵ��
		TemplateMethod_Bank t2 = new TemplateMethod_Bank() {
			
			@Override
			public void transact() {
				System.out.println("�����Ǯ");
			}
		};
		t2.process();
		
		TemplateMethod_Bank t3 = new TemplateMethod_Bank() {
			
			@Override
			public void transact() {
				System.out.println("����Ͷ�����");
			}
		};
		t3.process();
	}
}


class DrawMoney extends TemplateMethod_Bank{

	@Override
	public void transact() {
		System.out.println("����ȡǮҵ��");
	}
	
}