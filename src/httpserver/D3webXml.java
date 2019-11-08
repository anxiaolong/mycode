package httpserver;
/**
 * ʹ�ý���xml�����䣬ʵ����web�е�Ӧ��
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

public class D3webXml {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		//1.����SAX��������
		SAXParserFactory factory = SAXParserFactory.newInstance();
		//2.����������
		SAXParser parser = factory.newSAXParser();
		//3.����handler���󣬲�ͨ����������ʼ����
		WebHandler handler = new WebHandler();
		parser.parse(Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("httpserver/web.xml"), handler);
		//4.����WebHandler�����е�����
//		List<D2Entity> e = handler.getEntities();
//		List<D2Mapping> m = handler.getMappings();
//		for (D2Entity d2Entity : e) {
//			System.out.println(d2Entity.getClassString()+" "+d2Entity.getName());
//		}
//		for (D2Mapping d2Mapping : m) {
//			System.out.println(d2Mapping.getName()+" "+d2Mapping.getPatterns());
//		}
		//5.����WebContext���󣬳���ʹ��pattern�ҵ���Ӧ����
		D3WebContext webContext = new D3WebContext(handler.getEntities(), handler.getMappings());
		String classString = webContext.findClass("/g");
		System.out.println(classString);
		//6.ʹ�÷��䴴������ʵ�־����½����ע��ķ���
		Class clz = Class.forName(classString);
		System.out.println(clz);
		D3Servlet servlet = (D3Servlet)clz.getConstructor().newInstance();
		servlet.service();
	}
}

class WebHandler extends DefaultHandler {
	private D3Entity entity;
	private D3Mapping mapping;
	private List<D3Entity> entities;
	private List<D3Mapping> mappings;
	private boolean isMapping = false;
	private String tag;
	
	public List<D3Entity> getEntities() {
		return entities;
	}

	public List<D3Mapping> getMappings() {
		return mappings;
	}

	public WebHandler() {
		entities = new ArrayList<D3Entity>();
		mappings = new ArrayList<D3Mapping>();
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
//		System.out.println(qName);
		tag = qName;
		if (qName.equals("servlet")) {
			entity = new D3Entity();
		}
		if (qName.equals("servlet-mapping")) {
			mapping = new D3Mapping();
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

