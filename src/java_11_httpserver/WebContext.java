package java_11_httpserver;
/**
 * 通过url-pattern找到对应的类
 */
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WebContext {
	//目标：通过url-pattern找到对应的类
	//servlet-name-->servlet-class
	private Map<String, String> entityMap;
	//url-pattern-->servlet-name
	private Map<String, String> mappingMap;
	
	public WebContext(List<Entity> entities,List<Mapping> mappings) {
		entityMap = new HashMap<String, String>();
		mappingMap = new HashMap<String, String>();
		for (Entity d2Entity : entities) {
			entityMap.put(d2Entity.getName(), d2Entity.getClassString());
		}
		for (Mapping d2Mapping : mappings) {
			Set<String> set = d2Mapping.getPatterns();
			for (Iterator<String> setIterator=set.iterator();setIterator.hasNext();) {
				String temp = setIterator.next();
				mappingMap.put(temp, d2Mapping.getName());
			}
		}
	}
	
	//返回pattern对应的类
	public String findClass(String pattern) {
		String name = mappingMap.get(pattern);
		return entityMap.get(name);
	}
	
}
