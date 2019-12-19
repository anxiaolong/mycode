package jdbc;
/**
 * 使用Object[]封装数据，并存入list中
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Orm_test01 {
	public static void main(String[] args) {
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		List<Object[]> list = new ArrayList<Object[]>();
		try {
			String sql = "select * from emp;";
			stmt = JdbcUtils.getConnection().prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Object[] objects = new Object[3];
				objects[0] = rs.getObject("empname");
				objects[1] = rs.getObject("salary");
				objects[2] = rs.getObject("age");
				list.add(objects);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}  finally {
			JdbcUtils.release(conn, stmt, rs);
		}
		
		for (Object[] objects : list) {
			System.out.println(objects[0]);
			System.out.println(objects[1]);
			System.out.println(objects[2]);
		}
	}	
}
