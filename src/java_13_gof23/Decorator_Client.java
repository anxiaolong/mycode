package java_13_gof23;
/**
 * 测试装饰器模式
 * @author Administrator
 *
 */
public class Decorator_Client {
	public static void main(String[] args) {
		Car car = new Car();
		car.move();
		
		System.out.println("增加飞行功能#############");
		FlyCar flyCar = new FlyCar(car);
		flyCar.move();
		
		System.out.println("增加水上功能##########");
		WaterCar waterCar = new WaterCar(flyCar);
		waterCar.move();
		
		
	}
}
