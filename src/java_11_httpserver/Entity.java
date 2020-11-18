package java_11_httpserver;
/**
 * 用来存储解析出来的servlet数据
 * @author Administrator
 *
 */
public class Entity {
	private String name;
	private String classString;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClassString() {
		return classString;
	}
	public void setClassString(String classString) {
		this.classString = classString;
	}
	
}
