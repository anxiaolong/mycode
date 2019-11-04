package httpserver;
/**
 * 使用SAX解析，将xml文件中的信息，解析为对象
 */
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class TestXml2 {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		//SAX解析
		//1.获取解析工厂
		SAXParserFactory factory = SAXParserFactory.newInstance();
		//2.从解析工厂获取解析器
		SAXParser parser = factory.newSAXParser();
		//3.加载文档Document 注册处理器
		PersonHander hander = new PersonHander();
		//4.开始解析
		parser.parse(Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("httpserver/p.xml"), hander);
		//4.遍历list检查解析成对象的结果
		List<Person> persons = PersonHander.getPersons();
		for (Person person : persons) {
			System.out.println(person);
			System.out.println("name-->"+person.getName());
			System.out.println("age-->"+person.getAge());
		}
	}
}

class PersonHander extends DefaultHandler {
	private String s;
	private static List<Person> persons;
	private Person person;
	private String tag;
	
	@Override
	public void startDocument() throws SAXException {
		System.out.println("开始解析");
		persons = new ArrayList<Person>();
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if (qName!=null) {
			tag = qName;
			if (qName.equals("person")) {
				person = new Person();
			}
		}
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		s = new String(ch, start, length).trim(); //按字符解析并去掉前后空格
//		System.out.println(s);
		if (tag!=null&&s.length()>0) {//解析出来的s会有空格情况，需要加length()>0过滤
			if (tag.equals("name")) {
				person.setName(s);
			} 
			if (tag.equals("age")) {
				int age = Integer.valueOf(s);
				person.setAge(age);
			}
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equals("person")) {
			persons.add(person);
		}
	}
	
	@Override
	public void endDocument() throws SAXException {
		System.out.println("解析结束");
	}
	
	public static List<Person> getPersons() {
		return persons;
	}
}