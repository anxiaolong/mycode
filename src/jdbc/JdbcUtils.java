package jdbc;
/**
 * 封装jdbc工具类
 */
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {
	static Properties dbProperties = null;
	
	static {
		dbProperties = new Properties();
		try {
			dbProperties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//封装jdbc连接
	public static Connection getConnection() {
		try {
			Class.forName(dbProperties.getProperty("mysqlDriver"));
			String DB_URL = dbProperties.getProperty("mysqlURL");
			Connection conn = DriverManager.getConnection(DB_URL,dbProperties.getProperty("mysqlUser"),dbProperties.getProperty("mysqlPwd"));
			System.out.println(conn);
			return conn;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//封装资源回收的方法
	public static void release(Connection conn,PreparedStatement stmt,ResultSet rs) {
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
