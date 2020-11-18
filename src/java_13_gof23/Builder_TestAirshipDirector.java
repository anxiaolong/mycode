package java_13_gof23;
/**
 * 飞船组装者实体类
 * @author Administrator
 *
 */
public class Builder_TestAirshipDirector implements Builder_AirShipDirector {
	
	private Builder_AirshipBuilder builder;
	
	public Builder_TestAirshipDirector(Builder_AirshipBuilder builder) {
		this.builder = builder;
	}
	
	@Override
	public Builder_Airship directAirShip() {
		Engine e = builder.builderEngine();
		OrbitalModule o = builder.builderOrbitalModule();
		EscapeTower et = builder.builderEscapeTower();
		
		//装配成飞船
		Builder_Airship ship = new Builder_Airship();
		ship.setEngine(e);
		ship.setOrbitalModule(o);
		ship.setEscapeTower(et);
		
		return ship;
	}
	
	
}
