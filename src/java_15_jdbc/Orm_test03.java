package java_15_jdbc;
/**
 * 使用javabean对象，封装记录并存入list中
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Orm_test03 {
	public static void main(String[] args) {
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		List<Orm_emp> emps = new ArrayList<Orm_emp>();
		try {
			String sql = "select id, empname, age, salary, birthday from emp;";
			stmt = JdbcUtils.getConnection().prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Orm_emp emp = new Orm_emp(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getDate(5));
				emps.add(emp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}  finally {
			JdbcUtils.release(conn, stmt, rs);
		}
		
		for (Orm_emp orm_emp : emps) {
			System.out.println(orm_emp.getId()+"-"+orm_emp.getEmpname()+"-"+orm_emp.getAge()+"-"
					+orm_emp.getSalary()+"-"+orm_emp.getBirthday());
		}
	}	
}
