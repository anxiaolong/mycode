package httpserver;
/**
 * ����SAX����xml�ļ�
 */
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class TestXml {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		//SAX����
		//1.��ȡ��������
		SAXParserFactory factory = SAXParserFactory.newInstance();
		//2.�ӽ���������ȡ������
		SAXParser parser = factory.newSAXParser();
		//3.��д������
		//4.�����ĵ�Document ע�ᴦ����
		PHandler handler = new PHandler();
		//5.����
		parser.parse(Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("httpserver/p.xml"), handler);
	}
}

class PHandler extends DefaultHandler {
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		System.out.println(qName+"������ʼ");
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String contents = new String(ch, start, length).trim();
		if (contents.length()>0) {
			System.out.println("����Ϊ��"+contents);
		} else {
			System.out.println("����Ϊ��");
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.println(qName+"����������ʼ");
	}
	
	@Override
	public void endDocument() throws SAXException {
		System.out.println("�����ĵ�����");
	}
}





