package java_13_gof23;
/**
 * 房间对象
 * @author Administrator
 *
 */
public class State_RoomContext {
	private State_State state;
	
	public void setState(State_State s) {
		System.out.println("修改状态：");
		state = s;
		state.handle();
	}
}
