package dbUtil;

import interfaces.Dao.EntityResultSetMapping;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO层工具类
 * @author YangLun
 *
 */
public class DbUtil {
	//资源定位符
	public static final String url = "jdbc:mysql://localhost:3306/bank?user=root&password=YL635901";
	//加载驱动，只需执行一次即可
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("错误");
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取数据库连接
	 * @return
	 */
	public Connection getConnection(){
		try {
			Connection conn = DriverManager.getConnection(url);
			return conn;
		} catch (SQLException e) {
			System.out.println(11);
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 关闭数据库连接
	 * @param rs
	 * @param stmt
	 * @param conn
	 */
	public void close(ResultSet rs , Statement stmt , Connection conn){
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 执行增删改
	 * @param sql
	 * @param param
	 * @return	受影响的行
	 */
	public int excuteUpdate(String sql , Object... param){
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = this.getConnection();
			stmt = conn.prepareStatement(sql);
			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					stmt.setObject(i + 1, param[i]);
				}
			}
			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}	finally {
			this.close(null, stmt, conn);
		}
		return 0;
	}
	
	/**
	 * 执行查询操作
	 * @param ersm
	 * @param sql
	 * @param param
	 * @return List<E>
	 */
	public <E> List<E> excuteQuery(EntityResultSetMapping<E> ersm , String sql , Object... param){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		//用于存放结果集
		List<E> list = new ArrayList<E>();
		try {
			conn = DriverManager.getConnection(url);
			stmt = conn.prepareStatement(sql);
			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					stmt.setObject(i+1 , param[i]);
				}
			}
			rs = stmt.executeQuery();
			//解析结果集
			while (rs.next()) {
				E entity = ersm.mapping(rs);
				list.add(entity);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			this.close(rs, stmt, conn);
		}
		return null;
	}
}
