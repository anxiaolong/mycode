package jdbc;
/**
 * 测试PreparedStatement,有预编译，可以防止sql注入问题
 */
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test03 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn;
			PreparedStatement ps;
			
			String DB_URL = "jdbc:mysql://localhost:3306/testjdbc?useSSL=false&serverTimezone=Asia/Shanghai";
			try {
				
				conn = DriverManager.getConnection(DB_URL,"root","123456");
				System.out.println(conn);
				
				String sql = "insert into student (name,pwd,regtime) values (?,?,?); ";
				ps = conn.prepareStatement(sql);
				
//				//具体设置某个对象
//				ps.setString(1, "test");
//				ps.setString(2, "eeff123456");
//				ps.setDate(3, new Date(System.currentTimeMillis()));

				//使用setObject方法
				ps.setObject(1, "anxiaolong");
				ps.setObject(2, "123456");
				ps.setObject(3, new Date(System.currentTimeMillis()));

				System.out.println(ps.execute());
				System.out.println(ps.executeUpdate());
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
