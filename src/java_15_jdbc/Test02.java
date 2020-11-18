package java_15_jdbc;
/**
 * 测试使用Statment执行sql语句和sql注入的问题
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test02 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn;
			Statement stmt;
			
			String DB_URL = "jdbc:mysql://localhost:3306/testjdbc?useSSL=false&serverTimezone=Asia/Shanghai";
			try {
				
				conn = DriverManager.getConnection(DB_URL,"root","123456");
				stmt=conn.createStatement();//创建语句对象
				System.out.println(conn);
//				String creatTable = "CREATE TABLE `man` (\r\n" + 
//						"  `name` varchar(20) NOT NULL DEFAULT '',\r\n" + 
//						"  PRIMARY KEY (`name`)\r\n" + 
//						") ENGINE=InnoDB DEFAULT CHARSET=utf8;";
//				
//				stmt.execute(creatTable);//测试通过Statement执行sql语句
				
//				String insert = "insert into student (name) values (\"王五\");";
//				stmt.execute(insert);//测试向表中写入数据
				
				String id = "2 or 1=1;";
				String delete = "delete from student where id ="+id;
				System.out.println(stmt.execute(delete));//测试使用statement使用过程中，sql注入问题
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
