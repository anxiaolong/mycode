package api_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Set;


public class SerchSongByName_jdbc extends Object {
	
	private static Connection conn = null;
	private static PreparedStatement stmt = null;
	private static PreparedStatement stmt2 = null;
	private static ResultSet rs = null;
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String db_url = "jdbc:mysql://localhost:3306/testjdbc?useSSL=false&serverTimezone=Asia/Shanghai";
			conn = DriverManager.getConnection(db_url, "root", "111111");
			System.out.println(conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Set<String> Allid() throws Exception {
		Set<String> allidSet = new HashSet<String>();

		
		String sql = "select * from songid;";
		
		stmt = conn.prepareStatement(sql);
		rs = stmt.executeQuery();
		
		int count = 0;
		while (rs.next()) {
			String oldName = rs.getString("songName");
			String newName = oldName.trim().replace("£¨", "(")
					.replace("£©", ")");
			allidSet.add(newName);
			
			String sql2 = "UPDATE songid SET songName=\""+newName+"\" WHERE songName=\""+oldName+"\";";
			stmt2 = conn.prepareStatement(sql2);
			stmt2.execute();
			
			count++;
		}
		System.out.println(count);
		
		return allidSet;
	}
	
	public static void write2Db(String songName,String result) throws Exception {
		String sql = "UPDATE songid SET resultSet=\""+result+"\" WHERE songName=\""+songName+"\";";
		stmt = conn.prepareStatement(sql);
		stmt.executeUpdate();	
	}
	
}