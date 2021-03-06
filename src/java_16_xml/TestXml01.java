package java_16_xml;
/**
 * 使用dom4j读取xml文件，使用SAXReader读取
 */
import java.io.File;
import java.util.Iterator;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class TestXml01 {
	public static void main(String[] args) throws DocumentException {
		//1.创建SAXReader对象，用于读取xml文件
		SAXReader reader = new SAXReader();
		//2.读取xml文件，得到Document对象
		Document doc = reader.read(new File("src/xml/scores.xml"));
		//3.获取根元素
		Element root = doc.getRootElement();
//		System.out.println(root.getName());
		//4.获取根元素下所有子元素
		Iterator<?> it = root.elementIterator();
		while (it.hasNext()) {
			//取出元素
			Element e = (Element) it.next();
//			System.out.println(e.getName());
			//获取id属性
			Attribute id = e.attribute("id");
			System.out.println(id.getName()+"="+id.getValue());
			//获取student的子元素
			Element name = e.element("name");
			Element course = e.element("course");
			Element score = e.element("score");
			//打印
			System.out.println(name.getName()+"="+name.getStringValue());
			System.out.println(course.getName()+"="+course.getText());
			System.out.println(score.getName()+"="+score.getText());
			System.out.println("---------------------------------");
		}
		
	}
}
