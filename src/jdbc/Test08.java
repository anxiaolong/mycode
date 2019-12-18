package jdbc;
/**
 * 测试取出固定时间段的数据，使用SimpleDateFormat转化时间参数
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Test08 {
	public static void main(String[] args) {
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		
		try {
			String sql = "select * from student where timestamp>? and timestamp<?";
			stmt = JdbcUtils.getConnection().prepareStatement(sql);
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			stmt.setObject(1, new Timestamp(format.parse("2019-12-08 00:00:00").getTime()));
			stmt.setObject(2, new Timestamp(format.parse("2019-12-08 06:00:00").getTime()));
			ResultSet set = stmt.executeQuery();
			while (set.next()) {
				System.out.println(set.getString("name")+"-->"+set.getString("pwd")+"-->"+set.getTimestamp("timestamp"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  finally {
			JdbcUtils.release(conn, stmt, rs);
		}
	}	
}
