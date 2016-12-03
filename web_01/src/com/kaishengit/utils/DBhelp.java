package com.kaishengit.utils;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

public class DBhelp {
	//获取数据库连接
	private static Connection getConnection(){
		
		return ConnectionManger.getConnection();
	}
	
	/**
	 * 数据库查询方法
	 * @param sql
	 * @param handler
	 * @param params
	 * @return
	 */
	public static<T> T query(String sql, ResultSetHandler<T> handler,Object...params ) {
		Connection conn = getConnection();
		
		try {
			QueryRunner queryRunner = new QueryRunner();
			return queryRunner.query(conn, sql, handler, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(conn);
		}
		return null;
		
	}

	
	//增删改方法
	public static void update(String sql,Object...params){
		Connection conn = getConnection();
		
		QueryRunner queryRunner = new QueryRunner();
		
		try {
			queryRunner.update(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(conn);
		}
		
	}

	//关闭数据库连接
	private static void close(Connection conn) {
		if (conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
