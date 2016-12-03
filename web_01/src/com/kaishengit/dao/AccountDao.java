package com.kaishengit.dao;

import org.apache.commons.dbutils.handlers.BeanHandler;

import com.kaishengit.entity.Account;
import com.kaishengit.utils.DBhelp;

public class AccountDao {
	
	public void add (String name,String password){
	
		String sql = "insert into t_account(name,password) values (?,?)";
		
		DBhelp.update(sql, name,password);
		
	}
	
	public Account findByName (String name){
		
		String sql = "select * from t_account where name = ?";
		return DBhelp.query(sql, new BeanHandler<Account>(Account.class), name);
	}
	
}
