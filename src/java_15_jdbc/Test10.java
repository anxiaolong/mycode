package java_15_jdbc;
/**
 * 测试BLOB，因为项目为GBK，测试未通过
 */
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test10 {
	public static void main(String[] args) {
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		
		try {
			String sql = "insert into man (name,blob) values ('anxiaolong',?);";
			stmt = JdbcUtils.getConnection().prepareStatement(sql);
			stmt.setBlob(1, new FileInputStream(new File("c:/test/1.jpg")));
//			stmt.setClob(1, new FileReader(new File("c:/test/2019-12-18-getError")));
			stmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  finally {
			JdbcUtils.release(conn, stmt, rs);
		}
	}	
}
