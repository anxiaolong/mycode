package gof23;

public class FactorySimple_CarFactory {
	public static FactorySimple_Car creatAudi() {
		FactorySimple_Audi audi = new FactorySimple_Audi();
		return audi;
	}
	
	public static FactorySimple_Car creatByd() {
		FactorySimple_Byd byd = new FactorySimple_Byd();
		return byd;
	}
}
