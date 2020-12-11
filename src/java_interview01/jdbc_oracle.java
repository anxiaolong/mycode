package java_interview01;
/**
 * 手写JDBC
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class jdbc_oracle extends Object {
	public static void main(String[] args) throws Exception {
		//1.定义：连接，语句，结果集
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		//2.加载驱动，设置db_url
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String db_url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		
		//3.创建连接，创建语句，获得结果集
		conn = DriverManager.getConnection(db_url, "scott", "111111");
		System.out.println(conn);
		String sql = "select * from dept";
		stmt = conn.prepareStatement(sql);
		rs = stmt.executeQuery();
		
		//4.查看结果集
		while (rs.next()) {
			System.out.println("部门号："+rs.getString(1)+"-->部门名："+rs.getString(2)
        	+"-->其他信息："+rs.getString(3));
		}
		
		//5.资源回收
		rs.close();
		stmt.close();
		conn.close();
	}
}