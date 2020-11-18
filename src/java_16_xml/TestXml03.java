package java_16_xml;
/**
 * 将数据库中数据转化为xml文件保存
 */
import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;


public class TestXml03 {
	public static void main(String[] args) throws Exception {
		//1.定义：连接，语句，结果集
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		XMLWriter writer = null;
		
		//2.加载驱动，设置db_url
		Class.forName("com.mysql.cj.jdbc.Driver");
		String db_url = "jdbc:mysql://localhost:3306/testjdbc?useSSL=false&serverTimezone=Asia/Shanghai";
		
		//3.创建连接，创建语句，获得结果集
		conn = DriverManager.getConnection(db_url, "root", "123456");
		System.out.println(conn);
		String sql = "select * from student order by id;";
		stmt = conn.prepareStatement(sql);
		rs = stmt.executeQuery();
			
		//4.查看结果集,并执行写入xml操作
		OutputFormat format = OutputFormat.createPrettyPrint();
		writer = new XMLWriter(new FileWriter(new File("src/xml/students.xml")), format);
		Document doc = DocumentHelper.createDocument();
		Element root = doc.addElement("students");
		while (rs.next()) {
			System.out.println(String.valueOf(rs.getInt("id"))+" "+rs.getString("name")+" "+rs.getString("pwd"));
			Element student = root.addElement("student");
			student.addAttribute("id", String.valueOf(rs.getInt("id")));
			Element name = student.addElement("name");
			name.setText(rs.getString("name"));
			Element pwd = student.addElement("pwd");
			pwd.setText(rs.getString("pwd"));
			
		}
		writer.write(doc);
		//5.资源回收
		rs.close();
		stmt.close();
		conn.close();
		writer.close();
	}
}