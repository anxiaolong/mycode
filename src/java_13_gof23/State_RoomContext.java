package java_13_gof23;
/**
 * �������
 * @author Administrator
 *
 */
public class State_RoomContext {
	private State_State state;
	
	public void setState(State_State s) {
		System.out.println("�޸�״̬��");
		state = s;
		state.handle();
	}
}
