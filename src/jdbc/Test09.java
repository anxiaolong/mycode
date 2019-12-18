package jdbc;
/**
 * 测试CLOB类型存储大文本
 */
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test09 {
	public static void main(String[] args) {
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		
		try {
			String sql = "insert into man (name,clob) values ('anxiaolong',?);";
			stmt = JdbcUtils.getConnection().prepareStatement(sql);
			stmt.setClob(1, new FileReader(new File("c:/test/2019-12-18-getError")));
//			stmt.setClob(1, new BufferedReader(new InputStreamReader(new ByteArrayInputStream("测试下".getBytes()))));
			stmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  finally {
			JdbcUtils.release(conn, stmt, rs);
		}
	}	
}
