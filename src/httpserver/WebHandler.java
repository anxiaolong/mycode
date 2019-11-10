package httpserver;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class WebHandler extends DefaultHandler {
	private Entity entity;
	private Mapping mapping;
	private static List<Entity> entities;
	private static List<Mapping> mappings;
	private boolean isMapping = false;
	private String tag;
	
	public static List<Entity> getEntities() {
		return entities;
	}

	public static List<Mapping> getMappings() {
		return mappings;
	}

	public WebHandler() {
		entities = new ArrayList<Entity>();
		mappings = new ArrayList<Mapping>();
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
//		System.out.println(qName);
		tag = qName;
		if (qName.equals("servlet")) {
			entity = new Entity();
		}
		if (qName.equals("servlet-mapping")) {
			mapping = new Mapping();
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
