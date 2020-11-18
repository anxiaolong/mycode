package java_13_gof23;

public interface Facade_Gsj {
	void checkName();
}

class Cdgsj implements Facade_Gsj{

	@Override
	public void checkName() {
		System.out.println("检查名字是否有重名");
	}
	
}