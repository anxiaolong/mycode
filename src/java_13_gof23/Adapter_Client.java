package java_13_gof23;
/**
 * ����������ģʽ
 * @author Administrator
 *
 */
public class Adapter_Client {
	public static void main(String[] args) {
		//����ͨ���̳�ʵ�ֵ�������
		Adapter_Adapter1 a1 = new Adapter_Adapter1();
		a1.acceptInput();
		
		//����ͨ�����ʵ�ֵ�������
		Adapter_Adapter2 a2 = new Adapter_Adapter2(new Adapter_Keyboard());
		a2.handleInput();
	}
}
