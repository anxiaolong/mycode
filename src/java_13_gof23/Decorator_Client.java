package java_13_gof23;
/**
 * ����װ����ģʽ
 * @author Administrator
 *
 */
public class Decorator_Client {
	public static void main(String[] args) {
		Car car = new Car();
		car.move();
		
		System.out.println("���ӷ��й���#############");
		FlyCar flyCar = new FlyCar(car);
		flyCar.move();
		
		System.out.println("����ˮ�Ϲ���##########");
		WaterCar waterCar = new WaterCar(flyCar);
		waterCar.move();
		
		
	}
}
