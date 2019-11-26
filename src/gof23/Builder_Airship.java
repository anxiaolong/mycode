package gof23;


//飞创类
public class Builder_Airship {
	//建造非常需要三个组件
	private OrbitalModule orbitalModule;
	private Engine engine;
	private EscapeTower escapeTower;
	
	public void launch() {
		System.out.println("发射！");
	}

	public OrbitalModule getOrbitalModule() {
		return orbitalModule;
	}

	public void setOrbitalModule(OrbitalModule orbitalModule) {
		this.orbitalModule = orbitalModule;
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public EscapeTower getEscapeTower() {
		return escapeTower;
	}

	public void setEscapeTower(EscapeTower escapeTower) {
		this.escapeTower = escapeTower;
	}
	
	
}

//轨道舱类
class OrbitalModule{
	private String name;
	
	public OrbitalModule(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

//发动机类
class Engine{
	private String name;
	
	public Engine(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}

//逃逸塔类
class EscapeTower{
	private String name;
	
	public EscapeTower(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}







