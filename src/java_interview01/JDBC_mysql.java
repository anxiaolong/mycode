package java_interview01;
/**
 * ��дJDBC
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class JDBC_mysql extends Object {
	public static void main(String[] args) throws Exception {
		//1.���壺���ӣ���䣬�����
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		//2.��������������db_url
		Class.forName("com.mysql.cj.jdbc.Driver");
		String db_url = "jdbc:mysql://localhost:3306/testjdbc?useSSL=false&serverTimezone=Asia/Shanghai";
		
		//3.�������ӣ�������䣬��ý����
		conn = DriverManager.getConnection(db_url, "root", "123456");
		System.out.println(conn);
		String sql = "select * from student;";
		stmt = conn.prepareStatement(sql);
		rs = stmt.executeQuery();
		
		//4.�鿴�����
		while (rs.next()) {
			System.out.println(rs.getString("name")+" "+rs.getString("pwd"));
		}
		
		//5.��Դ����
		rs.close();
		stmt.close();
		conn.close();
	}
}