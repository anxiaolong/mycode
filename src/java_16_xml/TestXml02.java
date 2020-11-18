package java_16_xml;
/**
 * 使用dom4j，将信息保存到xml文件中
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
		//1.通过DocumentHelper生成一个Document对象
		Document doc = DocumentHelper.createDocument();
		//2.添加并得到根元素
		Element root = doc.addElement("books");
		//3.根元素添加子元素
		Element book = root.addElement("book");
		//4.book添加属性
		book.addAttribute("id", "b01");
		//5.book添加子元素
		Element name = book.addElement("name");
		Element author = book.addElement("author");
		Element price = book.addElement("price");
		//6.子元素添加文本
		name.addText("Java");
		author.addText("Tom");
		price.addText("98");
		//7.格式良好的输出
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter writer = new XMLWriter(new FileWriter(new File("src/xml/newBooks.xml")),format);
		writer.write(doc);
		//8.关闭资源
		writer.close();
	}
}
