package java_15_jdbc;
/**
 * ����������Ļ���ʹ�÷���
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test05 {
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
				long start = System.currentTimeMillis();
				for (int i = 0; i < 20000 ; i++) {
					stmt.addBatch("insert into student (name,pwd,regtime) values ('test"+i+"','123456',now());");
				}
				stmt.executeBatch();
				conn.commit();//�ύ����
				long end = System.currentTimeMillis();
				System.out.println("insert20000�����ݺ�ʱ��"+(end-start));
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
