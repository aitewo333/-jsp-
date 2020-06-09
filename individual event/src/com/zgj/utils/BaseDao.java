package com.zgj.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 操作数据库的基础类
 * 
 * @author yaoyaomice
 *
 */
public class BaseDao {
	private static final String className = "com.mysql.jdbc.Driver"; // 驱动类
	private static final String url = "jdbc:mysql://localhost:3306/bss?useSSL=false&characterEncoding=utf8"; //连接字符串
	private static final String user = "root"; //用户名
	private static final String password = "admin"; // 密码
	
	/**
	 * 加载数据库驱动
	 */
	static {
		try {
			Class.forName(className);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取数据库连接
	 * @return
	 */
	public Connection getConnection() {
		try {
			Connection conn = DriverManager.getConnection(url, user, password);
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 执行查询的sql语句，返回一个结果集
	 * 
	 * @param sql 要执行的查询语句 
	 */
	public ResultSet executeQuery(String sql, Object... params) {
		Connection conn = this.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			//给占位符赋值
			if (params != null && params.length != 0) {
				for (int i = 0; i < params.length; i++) {
					pstmt.setObject(i+1, params[i]);
				}
			}
			
			ResultSet rs = pstmt.executeQuery();
			
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * 执行增删改 的 sql语句， 返回受影响的行数
	 * 
	 * @param sql 要执行的sql语句
	 */
	public int executeUpdate(String sql, Object...params) {
		Connection conn = this.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			//给占位符赋值
			if (params != null && params.length != 0) {
				for (int i = 0; i < params.length; i++) {
					pstmt.setObject(i+1, params[i]);
				}
			}
			
			int result = pstmt.executeUpdate();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return  0;
	}
	
	/**
	 * 释放资源
	 * @param rs
	 */
	public void close(ResultSet rs) {
		try {
			rs.getStatement().getConnection().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}










