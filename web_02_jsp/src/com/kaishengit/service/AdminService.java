package com.kaishengit.service;

import org.apache.commons.codec.digest.DigestUtils;

import com.kaishengit.config.config;
import com.kaishengit.dao.AdminDao;
import com.kaishengit.entity.Admin;
import com.kaishengit.exception.ServiceException;

public class AdminService {

	private AdminDao adminDao = new AdminDao();

	public Admin findAdmin(String username, String password) throws ServiceException{

		
		Admin admin = adminDao.findByName(username);
		System.out.println(password);
		//验证用户密码也用密文
		//password = DigestUtils.md5Hex(password + config.PASSWORD_SALT);

		if (admin != null && admin.getPassword().equals(password)) {
			
			
			return admin;
		} else {
			throw new ServiceException("账号或密码错误");
		}
	}

	/**
	 * 注册图书管理员
	 * @param username
	 * @param password
	 * @param adminnum
	 */
	public void regist(String username, String password) throws ServiceException {
		
		Admin admin = adminDao.findByName(username);
		if(admin == null){
			//数据库中,密码存为密文
			//password = DigestUtils.md5Hex(password +config.PASSWORD_SALT);
		
			adminDao.regist(username,password);
		} else {
			throw new ServiceException("该用户名已经存在");
		}
	}

}
