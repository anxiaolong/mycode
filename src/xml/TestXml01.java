package xml;
/**
 * ʹ��dom4j��ȡxml�ļ���ʹ��SAXReader��ȡ
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
		//1.����SAXReader�������ڶ�ȡxml�ļ�
		SAXReader reader = new SAXReader();
		//2.��ȡxml�ļ����õ�Document����
		Document doc = reader.read(new File("src/xml/scores.xml"));
		//3.��ȡ��Ԫ��
		Element root = doc.getRootElement();
//		System.out.println(root.getName());
		//4.��ȡ��Ԫ����������Ԫ��
		Iterator<?> it = root.elementIterator();
		while (it.hasNext()) {
			//ȡ��Ԫ��
			Element e = (Element) it.next();
//			System.out.println(e.getName());
			//��ȡid����
			Attribute id = e.attribute("id");
			System.out.println(id.getName()+"="+id.getValue());
			//��ȡstudent����Ԫ��
			Element name = e.element("name");
			Element course = e.element("course");
			Element score = e.element("score");
			//��ӡ
			System.out.println(name.getName()+"="+name.getStringValue());
			System.out.println(course.getName()+"="+course.getText());
			System.out.println(score.getName()+"="+score.getText());
			System.out.println("---------------------------------");
		}
		
	}
}
