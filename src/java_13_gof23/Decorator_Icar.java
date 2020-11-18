package java_13_gof23;

//抽象构建
public interface Decorator_Icar {
	void move();
}


//具体构建角色
class Car implements Decorator_Icar {

	@Override
	public void move() {
		System.out.println("陆地上跑");
	}
	
}

//装饰角色
class SuperCar implements Decorator_Icar{
	protected Decorator_Icar car;
	
	public SuperCar(Decorator_Icar car) {
		this.car = car;
	}
	
	@Override
	public void move() {
		car.move();
	}
}

//具体装饰角色
class FlyCar extends SuperCar{
	public FlyCar(Decorator_Icar car) {
		super(car);
	}
	
	public void fly() {
		System.out.println("飞上天");
	}
	
	@Override
	public void move() {
		// TODO Auto-generated method stub
		super.move();
		fly();
	}
}

class WaterCar extends SuperCar {
	public WaterCar(Decorator_Icar car) {
		super(car);
	}
	
	public void swim() {
		System.out.println("水上游");
	}
	
	@Override
	public void move() {
		super.move();
		swim();
	}
}

class AICar extends SuperCar{
	public AICar(Decorator_Icar car) {
		super(car);
	}
	
	public void autoMove() {
		System.out.println("自动跑");
	}
	
	@Override
	public void move() {
		// TODO Auto-generated method stub
		super.move();
		autoMove();
	}
}









