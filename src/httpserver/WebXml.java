package httpserver;
/**
 * 把 web.xml文件的内容解析出来
 * 解析之后，需要的数据在WebHandler的
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
		//1.创建SAX解析工厂
		SAXParserFactory factory = SAXParserFactory.newInstance();
		//2.创建解析器
		SAXParser parser = factory.newSAXParser();
		//3.创建handler对象，并通过解析器开始解析
		WebHandler handler = new WebHandler();
		parser.parse(Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("httpserver/web.xml"), handler);
		//4.测试WebHandler容器中的数据
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

