package java_15_jdbc;
/**
 * 测试ResultSet结果集的使用
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test04 {
	public static void main(String[] args) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String DB_URL = "jdbc:mysql://localhost:3306/testjdbc?useSSL=false&serverTimezone=Asia/Shanghai";
			try {
				
				conn = DriverManager.getConnection(DB_URL,"root","123456");
				System.out.println(conn);
				
				String sql = "select id,name,pwd,regtime from student where id>?";
				ps = conn.prepareStatement(sql);
				ps.setObject(1, 7);
				
				rs = ps.executeQuery();
				while (rs.next()) {
					System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getDate(4));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//遵循：resultset-->statment-->connection这样的关闭顺序！一定要将三个trycatch块，分开写！
			try {
				if (rs!=null) {
					rs.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (ps!=null) {
					ps.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (conn!=null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}
}
