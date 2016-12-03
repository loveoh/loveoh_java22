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
	//数据库连接池
	static{
		//读取配置文件
		Properties prop = new Properties();
		
		try {
			prop.load(ConnectionManger.class.getClassLoader().getResourceAsStream("config.properties"));
			DRIVER = prop.getProperty("jdbc.driver");
			URL = prop.getProperty("jdbc.url");
			USERNAME = prop.getProperty("jdbc.username");
			PASSWORD = prop.getProperty("jdbc.password");
			
		
		} catch (IOException e) {
			throw new AccessDateException("读取config.properties文件异常",e);
		}
		
		
		//设置参数
		dataSource.setDriverClassName(DRIVER);
		dataSource.setUrl(URL);
		dataSource.setUsername(USERNAME);
		dataSource.setPassword(PASSWORD);
		
		dataSource.setInitialSize(5);//数据库初始连接数量
		dataSource.setMinIdle(5);//数据库最少连接数量
		dataSource.setMaxIdle(20);//数据库最大连接数量
		dataSource.setMaxWaitMillis(5000);//最长等待时间
		
	}
	
	/**
	 * 获得数据库连接池
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
			throw new AccessDateException("数据库连接器异常",e);
		}
		
		return conn;
		
	}
}
