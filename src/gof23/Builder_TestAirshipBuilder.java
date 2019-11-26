package gof23;
/**
 * �ɴ�������ʵ����
 * @author Administrator
 *
 */
public class Builder_TestAirshipBuilder implements Builder_AirshipBuilder {

	@Override
	public Engine builderEngine() {
		return new Engine("����Engine");
	}

	@Override
	public OrbitalModule builderOrbitalModule() {
		return new OrbitalModule("����OrbitalModule");
	}

	@Override
	public EscapeTower builderEscapeTower() {
		return new EscapeTower("����EscapeTower");
	}
	
}
