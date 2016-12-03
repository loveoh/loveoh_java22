package com.kaishengit.utils;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

public class DBhelp {
	//��ȡ���ݿ�����
	private static Connection getConnection(){
		
		return ConnectionManger.getConnection();
	}
	
	/**
	 * ���ݿ��ѯ����
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

	
	//��ɾ�ķ���
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

	//�ر����ݿ�����
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
