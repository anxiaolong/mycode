package java_interview01;
/**
 * 手写JDBC
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class JDBC_mysql extends Object {
	public static void main(String[] args) throws Exception {
		//1.定义：连接，语句，结果集
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		//2.加载驱动，设置db_url
		Class.forName("com.mysql.cj.jdbc.Driver");
		String db_url = "jdbc:mysql://localhost:3306/testjdbc?useSSL=false&serverTimezone=Asia/Shanghai";
		
		//3.创建连接，创建语句，获得结果集
		conn = DriverManager.getConnection(db_url, "root", "123456");
		System.out.println(conn);
		String sql = "select * from student;";
		stmt = conn.prepareStatement(sql);
		rs = stmt.executeQuery();
		
		//4.查看结果集
		while (rs.next()) {
			System.out.println(rs.getString("name")+" "+rs.getString("pwd"));
		}
		
		//5.资源回收
		rs.close();
		stmt.close();
		conn.close();
	}
}