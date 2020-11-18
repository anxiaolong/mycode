package java_13_gof23;
/**
 * ²âÊÔ×´Ì¬Ä£Ê½
 * @author Administrator
 *
 */
public class State_Client {
	public static void main(String[] args) {
		State_RoomContext room1 = new State_RoomContext();
		
		room1.setState(new FreeState());
		room1.setState(new CheckedInState());
		room1.setState(new BookedState());
	}
}
