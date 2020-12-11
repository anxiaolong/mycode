package java_interview01;
/**
 * ��дJDBC
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class jdbc_oracle extends Object {
	public static void main(String[] args) throws Exception {
		//1.���壺���ӣ���䣬�����
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		//2.��������������db_url
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String db_url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		
		//3.�������ӣ�������䣬��ý����
		conn = DriverManager.getConnection(db_url, "scott", "111111");
		System.out.println(conn);
		String sql = "select * from dept";
		stmt = conn.prepareStatement(sql);
		rs = stmt.executeQuery();
		
		//4.�鿴�����
		while (rs.next()) {
			System.out.println("���źţ�"+rs.getString(1)+"-->��������"+rs.getString(2)
        	+"-->������Ϣ��"+rs.getString(3));
		}
		
		//5.��Դ����
		rs.close();
		stmt.close();
		conn.close();
	}
}