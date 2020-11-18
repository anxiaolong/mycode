package java_13_gof23;

//���󹹽�
public interface Decorator_Icar {
	void move();
}


//���幹����ɫ
class Car implements Decorator_Icar {

	@Override
	public void move() {
		System.out.println("½������");
	}
	
}

//װ�ν�ɫ
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

//����װ�ν�ɫ
class FlyCar extends SuperCar{
	public FlyCar(Decorator_Icar car) {
		super(car);
	}
	
	public void fly() {
		System.out.println("������");
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
		System.out.println("ˮ����");
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
		System.out.println("�Զ���");
	}
	
	@Override
	public void move() {
		// TODO Auto-generated method stub
		super.move();
		autoMove();
	}
}









