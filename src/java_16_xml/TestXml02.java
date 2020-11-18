package java_16_xml;
/**
 * ʹ��dom4j������Ϣ���浽xml�ļ���
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class TestXml02 {
	public static void main(String[] args) throws IOException {
		//1.ͨ��DocumentHelper����һ��Document����
		Document doc = DocumentHelper.createDocument();
		//2.��Ӳ��õ���Ԫ��
		Element root = doc.addElement("books");
		//3.��Ԫ�������Ԫ��
		Element book = root.addElement("book");
		//4.book�������
		book.addAttribute("id", "b01");
		//5.book�����Ԫ��
		Element name = book.addElement("name");
		Element author = book.addElement("author");
		Element price = book.addElement("price");
		//6.��Ԫ������ı�
		name.addText("Java");
		author.addText("Tom");
		price.addText("98");
		//7.��ʽ���õ����
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter writer = new XMLWriter(new FileWriter(new File("src/xml/newBooks.xml")),format);
		writer.write(doc);
		//8.�ر���Դ
		writer.close();
	}
}
