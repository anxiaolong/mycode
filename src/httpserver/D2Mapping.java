package httpserver;

import java.util.HashSet;
import java.util.Set;

/**
 * 用来储存解析出来的servlet-mapping
 * @author Administrator
 *
 */
public class D2Mapping {
	private String name;
	private Set<String> patterns;
	
	public Set<String> getPatterns() {
		return patterns;
	}

	public void addPatterns(String s) {
		patterns.add(s);
	}

	public D2Mapping() {
		patterns = new HashSet<String>();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
