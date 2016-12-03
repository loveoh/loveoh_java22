package com.kaishengit.dao;

import org.apache.commons.dbutils.handlers.BeanHandler;

import com.kaishengit.entity.Admin;
import com.kaishengit.utils.DBhelep;

public class AdminDao {

	public Admin findByName(String username) {
		String sql = "select * from t_admin where username = ?";
		return DBhelep.query(sql, new BeanHandler<Admin>(Admin.class), username);
	}

	/**
	 * зЂВс
	 * @param password 
	 * @param username 
	 * 
	 */
	public void regist(String username, String password) {

		String sql = "insert into t_admin(username,password) values(?,?)";
		DBhelep.update(sql, username,password);
		
	}


}
