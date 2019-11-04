package httpserver;
/**
 * ʹ��SAX��������xml�ļ��е���Ϣ������Ϊ����
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
		//SAX����
		//1.��ȡ��������
		SAXParserFactory factory = SAXParserFactory.newInstance();
		//2.�ӽ���������ȡ������
		SAXParser parser = factory.newSAXParser();
		//3.�����ĵ�Document ע�ᴦ����
		PersonHander hander = new PersonHander();
		//4.��ʼ����
		parser.parse(Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("httpserver/p.xml"), hander);
		//4.����list�������ɶ���Ľ��
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
		System.out.println("��ʼ����");
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
		s = new String(ch, start, length).trim(); //���ַ�������ȥ��ǰ��ո�
//		System.out.println(s);
		if (tag!=null&&s.length()>0) {//����������s���пո��������Ҫ��length()>0����
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
		System.out.println("��������");
	}
	
	public static List<Person> getPersons() {
		return persons;
	}
}