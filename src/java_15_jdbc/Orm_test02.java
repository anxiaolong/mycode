package java_15_jdbc;
/**
 * 把jdbc获取的数据封装到map中
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Orm_test02 {
	//把单条数据存入到map中，多条数据存入list中
	public static void test1() {
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		
		try {
			String sql = "select empname,salary,age from emp;";
			stmt = JdbcUtils.getConnection().prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("empname", rs.getObject(1));
				map.put("salary", rs.getObject(2));
				map.put("age", rs.getObject(3));
				list.add(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}  finally {
			JdbcUtils.release(conn, stmt, rs);
		}
		
		for (Map<String, Object> map : list) {
			for (String key : map.keySet()) {
				System.out.println(key+"==>"+map.get(key));
			}
		}
	}
	
	//单条数据封装到map中，多条数据再封装到一个map中
	public static void test2() {
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		Map<String, Map<String, Object>> allMap = new HashMap<String, Map<String,Object>>();
		try {
			String sql = "select empname,salary,age from emp;";
			stmt = JdbcUtils.getConnection().prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("empname", rs.getObject(1));
				map.put("salary", rs.getObject(2));
				map.put("age", rs.getObject(3));
				allMap.put((String) rs.getObject(1), map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}  finally {
			JdbcUtils.release(conn, stmt, rs);
		}
		
		for (String allkey : allMap.keySet()) {
			System.out.println(allkey);
			for (String key : allMap.get(allkey).keySet()) {
				System.out.println(key+"-->"+allMap.get(allkey).get(key));
			}
		}
	}
	
	public static void main(String[] args) {
		test1();
		test2();
	}
}
