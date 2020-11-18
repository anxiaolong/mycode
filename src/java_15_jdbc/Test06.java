package java_15_jdbc;
/**
 * ��������ͬһ������Ҫôͬʱ�ɹ���Ҫôͬʱʧ��
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
				conn.setAutoCommit(false);//����Ϊ�ֶ��ύ
				stmt = conn.createStatement();
				
				String sql1 = "insert into student (name,pwd,regtime) values ('anxioalong','123456',now());";
				stmt.executeUpdate(sql1);
				System.out.println("����һ�����ݳɹ�");
				
				//��һ������ɹ����ȴ�10s
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//�ڶ�������ʧ�����ύ
				String sql2 = "insert into student (name,pwd,regtime) values ('anxioalong','666666',now());";
				stmt.executeUpdate(sql2);
				System.out.println("����һ�����ݳɹ�");
				
				conn.commit();//�ύ����
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				try {
					//ִ�г��쳣���ع�
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
			//��ѭ��resultset-->statment-->connection�����Ĺر�˳��һ��Ҫ������trycatch�飬�ֿ�д��
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
