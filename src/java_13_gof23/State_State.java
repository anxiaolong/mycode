package java_13_gof23;
/**
 * 状态接口和实体类
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
		System.out.println("房间以预定，别人不能定");
	}
	
}

class FreeState implements State_State{

	@Override
	public void handle() {
		// TODO Auto-generated method stub
		System.out.println("房间空闲，没人住");
	}
	
}

class CheckedInState implements State_State{

	@Override
	public void handle() {
		// TODO Auto-generated method stub
		System.out.println("房间已入住，请勿打扰");
	}
	
}



