package java_13_gof23;
/**
 * ״̬�ӿں�ʵ����
 * @author Administrator
 *
 */
public interface State_State{
	void handle();
}

class BookedState implements State_State{

	@Override
	public void handle() {
		// TODO Auto-generated method stub
		System.out.println("������Ԥ�������˲��ܶ�");
	}
	
}

class FreeState implements State_State{

	@Override
	public void handle() {
		// TODO Auto-generated method stub
		System.out.println("������У�û��ס");
	}
	
}

class CheckedInState implements State_State{

	@Override
	public void handle() {
		// TODO Auto-generated method stub
		System.out.println("��������ס���������");
	}
	
}



