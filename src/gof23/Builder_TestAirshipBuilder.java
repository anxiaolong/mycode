package gof23;
/**
 * 飞船建造者实体类
 * @author Administrator
 *
 */
public class Builder_TestAirshipBuilder implements Builder_AirshipBuilder {

	@Override
	public Engine builderEngine() {
		return new Engine("我是Engine");
	}

	@Override
	public OrbitalModule builderOrbitalModule() {
		return new OrbitalModule("我是OrbitalModule");
	}

	@Override
	public EscapeTower builderEscapeTower() {
		return new EscapeTower("我是EscapeTower");
	}
	
}
