package jdbc;
/**
 * 测试取出固定时间段的数据，使用SimpleDateFormat转化时间参数
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Test08 {
	public static void main(String[] args) {
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String DB_URL = "jdbc:mysql://localhost:3306/testjdbc?useSSL=false&serverTimezone=Asia/Shanghai";
			try {
				
				conn = DriverManager.getConnection(DB_URL,"root","123456");
				System.out.println(conn);
				String sql = "select * from student where timestamp>? and timestamp<?";
				stmt = conn.prepareStatement(sql);
				DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				try {
					stmt.setObject(1, new Timestamp(format.parse("2019-12-08 00:00:00").getTime()));
					stmt.setObject(2, new Timestamp(format.parse("2019-12-08 06:00:00").getTime()));
					ResultSet set = stmt.executeQuery();
					while (set.next()) {
						System.out.println(set.getString("name")+"-->"+set.getString("pwd")+"-->"+set.getTimestamp("timestamp"));
					}
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				try {
					//执行出异常，回滚
					conn.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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
				if (stmt!=null) {
					stmt.close();
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
