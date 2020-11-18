package java_15_jdbc;
/**
 * 测试事务，同一个事务，要么同时成功，要么同时失败
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test06 {
	public static void main(String[] args) {
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String DB_URL = "jdbc:mysql://localhost:3306/testjdbc?useSSL=false&serverTimezone=Asia/Shanghai";
			try {
				
				conn = DriverManager.getConnection(DB_URL,"root","123456");
				System.out.println(conn);
				conn.setAutoCommit(false);//设置为手动提交
				stmt = conn.createStatement();
				
				String sql1 = "insert into student (name,pwd,regtime) values ('anxioalong','123456',now());";
				stmt.executeUpdate(sql1);
				System.out.println("插入一条数据成功");
				
				//第一条插入成功，等待10s
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//第二条插入失败再提交
				String sql2 = "insert into student (name,pwd,regtime) values ('anxioalong','666666',now());";
				stmt.executeUpdate(sql2);
				System.out.println("插入一条数据成功");
				
				conn.commit();//提交事务
				
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
