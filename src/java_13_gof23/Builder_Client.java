package java_13_gof23;
/**
 * ���Խ�����ģʽ
 * @author Administrator
 *
 */
public class Builder_Client {
	public static void main(String[] args) {
		Builder_AirShipDirector director = new Builder_TestAirshipDirector(new Builder_TestAirshipBuilder());
		
		Builder_Airship ship = director.directAirShip();
		
		System.out.println(ship.getEngine().getName());
		
		ship.launch();
		
	}
}
