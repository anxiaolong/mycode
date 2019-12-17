package jdbc;
/**
 * 测试java.sql.Date,java.sql.Time,java.sql.Timestamp
 */
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Random;

public class Test07 {
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
				
				for (int i = 0; i < 1000; i++) {
					String sql = "insert into student (name,pwd,regtime,timestamp,time) values (?,?,?,?,?)";
					stmt = conn.prepareStatement(sql);
					stmt.setObject(1, "axl"+i);
					stmt.setObject(2, "123456");
					stmt.setObject(3, new Date(System.currentTimeMillis()));
					
					long time = new Random().nextInt(1000000000)+100000000;
					stmt.setTimestamp(4, new Timestamp(System.currentTimeMillis()-time));
					stmt.setTime(5, new Time(System.currentTimeMillis()-time));
					stmt.executeUpdate();
				}
				
				System.out.println("插入完成");
				
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
