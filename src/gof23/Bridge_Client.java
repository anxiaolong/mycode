package gof23;
/**
 * �����Ž�ģʽ
 * @author Administrator
 *
 */
public class Bridge_Client {
	public static void main(String[] args) {
		//��������ʼǱ�����
		Bridge_Computer lenovoLaptop = new Laptop(new Lenovo());
		lenovoLaptop.sale();
		//���۴���̨ʽ��
		Bridge_Computer dellDesktop = new Desktop(new Dell());
		dellDesktop.sale();
	}
}
