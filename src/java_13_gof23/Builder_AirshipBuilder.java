package java_13_gof23;
/**
 * 飞船建造者接口
 * @author Administrator
 *
 */
public interface Builder_AirshipBuilder {
	Engine builderEngine();
	OrbitalModule builderOrbitalModule();
	EscapeTower builderEscapeTower();
}
