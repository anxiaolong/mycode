package gof23;
/**
 * Ʒ�ƽӿں�ʵ����
 * @author Administrator
 *
 */
public interface Bridge_Brand {
	public void sale();
}

class Lenovo implements Bridge_Brand {

	@Override
	public void sale() {
		System.out.println("�����������");
	}
	
}

class Dell implements Bridge_Brand {

	@Override
	public void sale() {
		System.out.println("���۴�������");
	}
	
}

class Shenzhou implements Bridge_Brand {

	@Override
	public void sale() {
		System.out.println("�������ݵ���");
	}
	
}