package httpserver;
/**
 * �� web.xml�ļ������ݽ�������
 * ����֮����Ҫ��������WebHandler��
 */
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class WebXml {
	
	public static WebHandler parserXml() throws ParserConfigurationException, SAXException, IOException {
		//1.����SAX��������
		SAXParserFactory factory = SAXParserFactory.newInstance();
		//2.����������
		SAXParser parser = factory.newSAXParser();
		//3.����handler���󣬲�ͨ����������ʼ����
		WebHandler handler = new WebHandler();
		parser.parse(Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("httpserver/web.xml"), handler);
		//4.����WebHandler�����е�����
		List<Entity> e = handler.getEntities();
		List<Mapping> m = handler.getMappings();
		for (Entity Entity : e) {
			System.out.println(Entity.getClassString()+" "+Entity.getName());
		}
		for (Mapping Mapping : m) {
			System.out.println(Mapping.getName()+" "+Mapping.getPatterns());
		}
		return handler;
	}
	
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		parserXml();
	}
}

