package gof23;
/**
 * ���Լ򵥹���ģʽ
 * ����ģʽ�ĺô��Ǳ���ֱ�Ӻͻ�������ҵ�񽻻������Ͽ���ԭ��
 * 
 * @author Administrator
 *
 */
public class FactorySimple_Client {
	public static void main(String[] args) {
		//�����ù���ģʽ��������
		FactorySimple_Audi car1 = new FactorySimple_Audi();
		FactorySimple_Byd car2 = new FactorySimple_Byd();
		car1.run();
		car2.run();
		
		//ʹ�ù���ģʽ��������
		FactorySimple_Car audi = FactorySimple_CarFactory.creatAudi();
		FactorySimple_Car byd = FactorySimple_CarFactory.creatByd();
		audi.run();
		byd.run();
	}
}
