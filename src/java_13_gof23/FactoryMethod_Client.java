package java_13_gof23;
/**
 * ���Թ�������ģʽ
 * ��Ʒ�͹���������Ϊ�ӿڣ����һ����Ʒ��Ӧ���һ������
 * @author Administrator
 *
 */
public class FactoryMethod_Client {
	public static void main(String[] args) {
		FactoryMethod_Car audi = new FactoryMethod_AudiFactory().createCar();
		audi.run();
	}
}
