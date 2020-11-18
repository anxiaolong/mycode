package java_13_gof23;
/**
 * 中介者接口和President实体类
 */
import java.util.HashMap;
import java.util.Map;

public interface Mediator_Mediator {
	void register(String dname,Mediator_Department d);
	void command(String dname);
}

class President implements Mediator_Mediator{
	private Map<String, Mediator_Department> map = new HashMap<String, Mediator_Department>();
	
	@Override
	public void register(String dname, Mediator_Department d) {
		map.put(dname, d);
	}

	@Override
	public void command(String dname) {
		map.get(dname).selfAction();
	}
	
}
