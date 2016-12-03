package com.kaishengit.utils;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import com.kaishengit.exception.AccessDateException;

public class DBhelep {
	
	//获取数据库连接
	private static Connection getConnection() throws AccessDateException{
		return ConnectionManger.getConnection();
	}
	
	
	public static<T> T query(String sql,ResultSetHandler<T> handler,Object...params){
		
		
		QueryRunner queryRunner = new QueryRunner(ConnectionManger.getDataSource());
		try {
		T t = queryRunner.query(sql, handler, params);
		return t;
		} catch (SQLException e) {
			throw new AccessDateException("数据库" + sql + "异常",e);
			
		}

		
		/*T t = null;
		Connection conn = getConnection();
		QueryRunner queryRunner = new QueryRunner();
		try {
			t = queryRunner.query(conn, sql, handler, params);
		} catch (SQLException e) {
			throw new AccessDateException("数据库" + sql + "异常",e);
		}
		return t;*/
	}
	
	
	/**
	 * 增删改方法
	 * @param sql
	 * @param params
	 */
	public static void update(String sql,Object...params){
		
		QueryRunner queryRunner = new QueryRunner(ConnectionManger.getDataSource());
		try {
			queryRunner.update(sql, params);
		} catch (SQLException e) {
			throw new AccessDateException("数据库" + sql + "异常",e);
		}
		
	
		/*Connection conn = getConnection();
		
		QueryRunner queryRunner = new QueryRunner();
		try {
			queryRunner.update(conn, sql, params);
		} catch (SQLException e) {
			throw new AccessDateException("数据库" + sql + "异常",e);
		}finally{
			close(conn);
		}*/
		
	}


	private static void close(Connection conn) {
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				throw new AccessDateException("数据库关闭器异常",e);
			}
		}
		
	}
}
