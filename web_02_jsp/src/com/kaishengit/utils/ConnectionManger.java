package com.kaishengit.utils;

import java.io.IOException;
import java.sql.Connection;

import java.util.Properties;

import javax.sql.DataSource;


import org.apache.commons.dbcp2.BasicDataSource;


import com.kaishengit.exception.AccessDateException;

public class ConnectionManger {
	
	private static final String DRIVER; //= "com.mysql.jdbc.Driver";
	private static final String URL; //= "jdbc:mysql:///book_manger";
	private static final String USERNAME; //= "root";
	private static final String PASSWORD; //= "root";
	private static BasicDataSource dataSource = new BasicDataSource();
	//���ݿ����ӳ�
	static{
		//��ȡ�����ļ�
		Properties prop = new Properties();
		
		try {
			prop.load(ConnectionManger.class.getClassLoader().getResourceAsStream("config.properties"));
			DRIVER = prop.getProperty("jdbc.driver");
			URL = prop.getProperty("jdbc.url");
			USERNAME = prop.getProperty("jdbc.username");
			PASSWORD = prop.getProperty("jdbc.password");
			
		
		} catch (IOException e) {
			throw new AccessDateException("��ȡconfig.properties�ļ��쳣",e);
		}
		
		
		//���ò���
		dataSource.setDriverClassName(DRIVER);
		dataSource.setUrl(URL);
		dataSource.setUsername(USERNAME);
		dataSource.setPassword(PASSWORD);
		
		dataSource.setInitialSize(5);//���ݿ��ʼ��������
		dataSource.setMinIdle(5);//���ݿ�������������
		dataSource.setMaxIdle(20);//���ݿ������������
		dataSource.setMaxWaitMillis(5000);//��ȴ�ʱ��
		
	}
	
	/**
	 * ������ݿ����ӳ�
	 * @return
	 */
	public static DataSource getDataSource(){
		return dataSource;
	}
	
	
	public static Connection getConnection(){
		Connection conn = null;
		try {
			
			conn = dataSource.getConnection();
		} catch (Exception e) {
			throw new AccessDateException("���ݿ��������쳣",e);
		}
		
		return conn;
		
	}
}
