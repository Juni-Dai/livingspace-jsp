package cn.juni.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {

	/*private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
	private static final String UNAME = "scott";
	private static final String PASSWORD = "tiger";*/
	
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/livingspace";
	private static final String UNAME = "root";
	private static final String PASSWORD = "root";
	
	static {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取数据库链接对象
	 * @return
	 */
	public static Connection getConn() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, UNAME, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * 增删改通用
	 * @param sql
	 * @param objects
	 * @return
	 */
	public static int method(String sql,Object...objects) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConn();
			ps = conn.prepareStatement(sql);
			if(objects!=null) {
				for(int i=0;i<objects.length;i++) {
					ps.setObject(i+1, objects[i]);
				}
			}
			int result = ps.executeUpdate();
			return result;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(conn,ps,null);
		}
		return 0;
	}
	
	/**
	 * 关闭数据库
	 * @param conn
	 * @param st
	 * @param rs
	 */
	public static void close(Connection conn,Statement st,ResultSet rs) {
		try {
			if(rs != null) {
				rs.close();
			}
			if(st != null) {
				st.close();
			}
			if(conn != null){
				conn.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
