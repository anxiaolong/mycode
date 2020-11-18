package java_15_jdbc;
/**
 * 测试jdbc建立连接的效率
 * 建立jdbc连接效率非常低
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//下载jdbc驱动地址：https://mvnrepository.com/artifact/mysql/mysql-connector-java/8.0.18
public class Test01 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn;
			
			String DB_URL = "jdbc:mysql://localhost:3306/testjdbc?useSSL=false&serverTimezone=Asia/Shanghai";
			try {
				long start = System.currentTimeMillis();
				
				conn = DriverManager.getConnection(DB_URL,"root","123456");
				
				long end = System.currentTimeMillis();
				System.out.println(conn);
				System.out.println("建立连接耗时："+(end-start));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
