package httpserver;
/**
 * 使用解析xml、反射，实现在web中的应用
 * 
 */
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class D2webXml {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		//1.创建SAX解析工厂
		SAXParserFactory factory = SAXParserFactory.newInstance();
		//2.创建解析器
		SAXParser parser = factory.newSAXParser();
		//3.创建handler对象，并通过解析器开始解析
		WebHandler handler = new WebHandler();
		parser.parse(Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("httpserver/web.xml"), handler);
		//4.测试WebHandler容器中的数据
//		List<D2Entity> e = handler.getEntities();
//		List<D2Mapping> m = handler.getMappings();
//		for (D2Entity d2Entity : e) {
//			System.out.println(d2Entity.getClassString()+" "+d2Entity.getName());
//		}
//		for (D2Mapping d2Mapping : m) {
//			System.out.println(d2Mapping.getName()+" "+d2Mapping.getPatterns());
//		}
		//5.创建WebContext对象，尝试使用pattern找到对应的类
		D2WebContext webContext = new D2WebContext(handler.getEntities(), handler.getMappings());
		String classString = webContext.findClass("/g");
		System.out.println(classString);
		//6.使用反射创建对象，实现具体登陆或者注册的方法
		Class clz = Class.forName(classString);
		System.out.println(clz);
		D2Servlet servlet = (D2Servlet)clz.getConstructor().newInstance();
		servlet.service();
	}
}

class WebHandler extends DefaultHandler {
	private D2Entity entity;
	private D2Mapping mapping;
	private List<D2Entity> entities;
	private List<D2Mapping> mappings;
	private boolean isMapping = false;
	private String tag;
	
	public List<D2Entity> getEntities() {
		return entities;
	}

	public List<D2Mapping> getMappings() {
		return mappings;
	}

	public WebHandler() {
		entities = new ArrayList<D2Entity>();
		mappings = new ArrayList<D2Mapping>();
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
//		System.out.println(qName);
		tag = qName;
		if (qName.equals("servlet")) {
			entity = new D2Entity();
		}
		if (qName.equals("servlet-mapping")) {
			mapping = new D2Mapping();
			isMapping = true;
		}
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String s = new String(ch, start, length).trim();
		if (s.length()>0) {
			if (isMapping) {
				if (tag.equals("servlet-name")) {
					mapping.setName(s);
				}
				if (tag.equals("url-pattern")) {
					mapping.addPatterns(s);
				}
			}
			if (tag.equals("servlet-name")) {
				entity.setName(s);
			}
			if (tag.equals("servlet-class")) {
				entity.setClassString(s);
			}
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName!=null) {
			if (qName.equals("servlet-mapping")) {
				mappings.add(mapping);
			} else if(qName.equals("servlet")) {
				entities.add(entity);
			}
		}
	}
	
}

